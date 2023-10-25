package dev.aherscu.instancio.experiment.model;

import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class CreatePersonRequest {
    @NotNull
    public final Person person;

    // other metadata
}
