package dev.aherscu.instancio.experiment.model;

import javax.validation.*;
import javax.validation.constraints.*;
import lombok.*;
import lombok.experimental.*;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class CreatePersonRequest {
    @NotNull
    @Valid
    public final Person person;

    // other metadata
}
