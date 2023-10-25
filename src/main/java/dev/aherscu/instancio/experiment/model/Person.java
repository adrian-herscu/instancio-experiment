package dev.aherscu.instancio.experiment.model;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class Person {
    public final Phone phone;
    public final Address address;
}
