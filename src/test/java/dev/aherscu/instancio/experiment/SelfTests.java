package dev.aherscu.instancio.experiment;

import static dev.aherscu.instancio.experiment.utils.ValidatorUtils.*;

import com.google.common.collect.*;
import dev.aherscu.instancio.experiment.model.*;
import lombok.extern.slf4j.*;
import lombok.*;
import org.instancio.*;
import org.testng.annotations.*;

@Slf4j
public class SelfTests {
    @Test
    public void selfTest() {
        log.debug("hello");
        assert true;
    }

    @Test
    public void shouldGenerateAddress() {
        Instancio.stream(Address.class)
            .limit(3)
            .forEach(a -> log.debug(a.toString()));
    }

    @Test
    public void shouldHaveStableHash() {
        log.debug("{}", "hello".hashCode());
        log.debug("{}", ImmutableSet.of("hello", "world").hashCode());
    }

    @Test
    public void shouldValidateCreatePersonRequest() {
        val request = CreatePersonRequest.builder()
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
            .build();

        val violations = messagesOf(validator.validate(request));

        // ISSUE cannot use this hash for comparisons
        log.debug("hash {}", violations.hashCode());
        violations.forEach(m -> log.debug("{}", m));
    }
}
