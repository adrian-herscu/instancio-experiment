package dev.aherscu.instancio.experiment.model;

import javax.validation.*;
import javax.validation.constraints.*;
import lombok.*;
import lombok.experimental.*;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class Person {
    @NotNull
    @Valid
    public final Phone phone;
    @NotNull
    @Valid
    public final Address address;
}
