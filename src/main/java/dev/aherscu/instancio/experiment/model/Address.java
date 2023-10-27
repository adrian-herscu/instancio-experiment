package dev.aherscu.instancio.experiment.model;

import javax.validation.constraints.*;
import lombok.*;
import lombok.experimental.*;

@Getter
@SuperBuilder
@ToString
@EqualsAndHashCode
public class Address {
    @Size(min = 1, max = 20)
    @NotNull
    public final String line1;
    @Size(min = 1, max = 20)
    public final String line2;
    @Size(min = 1, max = 20)
    public final String city;
    @Size(min = 1, max = 20)
    public final String country;
    @Size(min = 1, max = 20)
    public final String zipCode;
}
