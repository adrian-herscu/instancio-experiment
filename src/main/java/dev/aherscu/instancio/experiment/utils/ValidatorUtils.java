package dev.aherscu.instancio.experiment.utils;

import static com.google.common.collect.ImmutableSet.*;

import com.google.common.collect.*;
import java.util.*;
import javax.validation.*;
import lombok.experimental.*;

@UtilityClass
public class ValidatorUtils {
    public static final Validator validator =
        Validation.buildDefaultValidatorFactory()
            .getValidator();

    public static <T> ImmutableSet<String> messagesOf(
        final Set<ConstraintViolation<T>> violations) {

        return violations
            .stream()
            .map(ConstraintViolation::getMessage)
            .collect(toImmutableSet());
    }
}
