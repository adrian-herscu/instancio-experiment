package dev.aherscu.instancio.experiment.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class Phone {
    @Min(1)
    @Max(999)
    public final int countryCode;
    public final int number;
}
