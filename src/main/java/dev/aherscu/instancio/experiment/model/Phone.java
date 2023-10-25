package dev.aherscu.instancio.experiment.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Phone {
    @Min(1)
    @Max(999)
    public final int countryCode;
    public final int number;
}
