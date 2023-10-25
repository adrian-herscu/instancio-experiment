package dev.aherscu.instancio.experiment.logic;

import dev.aherscu.instancio.experiment.model.CreatePersonRequest;
import dev.aherscu.instancio.experiment.model.CreatePersonResponse;
import javax.validation.Validation;
import javax.validation.Validator;

public class PersonRequestHandler {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public CreatePersonResponse handle(final CreatePersonRequest request) {
        return CreatePersonResponse.builder()
                .message(request.toString())
                .violations(validator.validate(request))
                .build();
    }
}
