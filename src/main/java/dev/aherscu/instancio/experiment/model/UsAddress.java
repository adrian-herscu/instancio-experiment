package dev.aherscu.instancio.experiment.model;

import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
public class UsAddress extends Address {
    @Size(min = 1, max = 20)
    public final String county;
}
