package dev.aherscu.instancio.experiment;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import dev.aherscu.instancio.experiment.logic.*;
import dev.aherscu.instancio.experiment.model.*;
import org.testng.annotations.*;

public class PersonRequestHandlerTest {

    @DataProvider
    private static CreatePersonRequest[] data() {
        return new CreatePersonRequest[] {
            CreatePersonRequest.builder()
                .person(Person.builder()
                    .address(Address.builder()
                        .line1("1")
                        .city("A")
                        .country("A")
                        .zipCode("1")
                        .build())
                    .phone(Phone.builder()
                        .countryCode(1)
                        .number(1)
                        .build())
                    .build())
                .build(),
        };
    }

    @DataProvider
    private static CreatePersonRequest[] negativeData() {
        return new CreatePersonRequest[] {
            CreatePersonRequest.builder()
                .build(),
            CreatePersonRequest.builder()
                .person(Person.builder()
                    .build())
                .build(),
            CreatePersonRequest.builder()
                .person(Person.builder()
                    .address(Address.builder()
                        .line1("1")
                        .city("A")
                        .country("A")
                        .zipCode("1")
                        .build())
                    .phone(Phone.builder()
                        .countryCode(10000)
                        .number(1)
                        .build())
                    .build())
                .build(),
        };
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
