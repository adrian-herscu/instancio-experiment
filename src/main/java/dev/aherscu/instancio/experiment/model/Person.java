package dev.aherscu.instancio.experiment.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class Person {
    public final Phone phone;
    public final Address address;
}
