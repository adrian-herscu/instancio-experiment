package dev.aherscu.instancio.experiment;

import dev.aherscu.instancio.experiment.logic.PersonRequestHandler;
import dev.aherscu.instancio.experiment.model.Address;
import dev.aherscu.instancio.experiment.model.CreatePersonRequest;
import dev.aherscu.instancio.experiment.model.CreatePersonResponse;
import dev.aherscu.instancio.experiment.model.Person;
import dev.aherscu.instancio.experiment.model.Phone;
import dev.aherscu.instancio.experiment.utils.Tuple;
import org.instancio.Gen;
import org.instancio.Instancio;
import org.instancio.Model;
import org.instancio.TargetSelector;
import org.instancio.generator.Generator;
import org.instancio.generator.GeneratorSpec;
import org.instancio.generator.specs.StringSpec;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.instancio.Select.all;
import static org.instancio.Select.field;

public class PersonRequestHandlerTest {

    private static Model<CreatePersonRequest> createValidRequestModel() {
        return Instancio.of(CreatePersonRequest.class)
                .withSettings(Settings.create()
                        .set(Keys.BEAN_VALIDATION_ENABLED, true))
                .toModel();
    }

    @DataProvider
    private static CreatePersonRequest[] data() {
        return Instancio.stream(createValidRequestModel())
                .limit(100)
                .toArray(CreatePersonRequest[]::new);
    }

    @DataProvider
    private static CreatePersonRequest[] negativeData() {
        // either empty or a string of 21+ characters in length
        final StringSpec emptyStringOrLengthOver21 = Gen.string().allowEmpty().minLength(21);
        final Generator<?> nullGenerator = random -> null;

        // create an otherwise valid object, but with a single invalid field
        final List<Tuple<TargetSelector, GeneratorSpec<?>>> negativeInputs = Arrays.asList(
            Tuple.of(field(Address::getLine1), Gen.string().nullable().allowEmpty().minLength(21)), // line1 is not nullable
            Tuple.of(field(Address::getLine2), emptyStringOrLengthOver21),
            Tuple.of(field(Address::getCity), emptyStringOrLengthOver21),
            Tuple.of(field(Address::getCountry), emptyStringOrLengthOver21),
            Tuple.of(field(Address::getZipCode), emptyStringOrLengthOver21),
            // random number outside the range [1-999]
            Tuple.of(field(Phone::getCountryCode), Gen.ints().range(Integer.MIN_VALUE, 0).range(1000, Integer.MAX_VALUE)),
            Tuple.of(all(Person.class), nullGenerator),
            Tuple.of(all(Address.class), nullGenerator),
            Tuple.of(all(Phone.class), nullGenerator)
        );

        return negativeInputs.stream()
                .map(input -> Instancio.of(createValidRequestModel())
                        .generate(input.getKey(), input.getValue())
                        .create())
                .toArray(CreatePersonRequest[]::new);
    }

    @Test(dataProvider = "negativeData")
    public void shouldDeny(final CreatePersonRequest request) {
        assertThat(new PersonRequestHandler()
                .handle(request),
            both(is(CreatePersonResponse.from(request)))
                .and(hasProperty("violations", not(empty()))));
    }

    @Test(dataProvider = "data")
    public void shouldHandle(final CreatePersonRequest request) {
        assertThat(new PersonRequestHandler()
                .handle(request),
            both(is(CreatePersonResponse.from(request)))
                .and(hasProperty("violations", empty())));
    }
}
