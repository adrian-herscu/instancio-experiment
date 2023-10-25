package dev.aherscu.instancio.experiment.model;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class CreatePersonResponse {
    
    public final String message;
    public final Set<ConstraintViolation<CreatePersonRequest>> violations;
}
