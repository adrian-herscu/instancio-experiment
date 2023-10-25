package dev.aherscu.instancio.experiment;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSet;

import dev.aherscu.instancio.experiment.logic.PersonRequestHandler;
import dev.aherscu.instancio.experiment.model.CreatePersonRequest;
import dev.aherscu.instancio.experiment.model.CreatePersonResponse;
import dev.aherscu.instancio.experiment.model.Person;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

public class PersonRequestHandlerTest {

    @SuperBuilder
    @ToString
    static class TestData {
        final CreatePersonRequest request;
        final CreatePersonResponse response;
    }

    @DataProvider
    private static TestData[] data() {
        return new TestData[] {
                TestData.builder()
                        .request(CreatePersonRequest.builder()
                                .build())
                        .response(CreatePersonResponse.builder()
                                .message("CreatePersonRequest(person=null)")
                                .violations(ImmutableSet.of())
                                .build())
                        .build(),
                TestData.builder()
                        .request(CreatePersonRequest.builder()
                                .person(Person.builder()
                                        .build())
                                .build())
                        .response(CreatePersonResponse.builder()
                                .message("CreatePersonRequest(person=Person(phone=null, address=null))")
                                .build())
                        .build()

        };
    }

    @Test(dataProvider = "data")
    public void shouldHandle(final TestData data) {
        assertThat(new PersonRequestHandler()
                .handle(data.request),
                is(data.response));
    }
}
