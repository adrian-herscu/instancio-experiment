package dev.aherscu.instancio.experiment.logic;

import static dev.aherscu.instancio.experiment.utils.ValidatorUtils.*;

import dev.aherscu.instancio.experiment.model.*;

public class PersonRequestHandler {

    public CreatePersonResponse handle(final CreatePersonRequest request) {
        return CreatePersonResponse.builder()
                .message(request.toString())
                .violations(messagesOf(validator.validate(request)))
                .build();
    }
}
