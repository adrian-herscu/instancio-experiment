package dev.aherscu.instancio.experiment.model;

import javax.validation.constraints.*;
import lombok.*;
import lombok.experimental.*;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class Phone {
    @Min(1)
    @Max(999)
    public final int countryCode;
    public final int number;
}
