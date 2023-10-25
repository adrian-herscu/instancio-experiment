package dev.aherscu.instancio.experiment.model;

import javax.validation.constraints.*;
import lombok.*;
import lombok.experimental.*;

@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true)
public class UsAddress extends Address {
    @Size(min = 1, max = 20)
    public final String county;
}
