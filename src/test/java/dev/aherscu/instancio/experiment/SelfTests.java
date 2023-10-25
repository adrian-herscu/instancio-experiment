package dev.aherscu.instancio.experiment;

import org.instancio.Instancio;
import org.testng.annotations.Test;

import dev.aherscu.instancio.experiment.model.Address;
import lombok.extern.slf4j.Slf4j;

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
}
