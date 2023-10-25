package dev.aherscu.instancio.experiment.model;

import static dev.aherscu.instancio.experiment.utils.ValidatorUtils.*;

import com.google.common.collect.*;
import lombok.*;
import lombok.experimental.*;

@SuperBuilder
@ToString
@EqualsAndHashCode
public class CreatePersonResponse {

    public final String               message;
    @Getter
    public final ImmutableSet<String> violations;

    public static CreatePersonResponse from(final CreatePersonRequest request) {
        return CreatePersonResponse.builder()
            .message(request.toString())
            .violations(messagesOf(validator.validate(request)))
            .build();
    }
}
