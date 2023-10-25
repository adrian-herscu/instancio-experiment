package dev.aherscu.instancio.experiment.model;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class CreatePersonRequest {
    public final Person person;

    // other metadata
}
