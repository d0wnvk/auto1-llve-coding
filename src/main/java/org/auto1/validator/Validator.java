package org.auto1.validator;

import java.util.Optional;
import org.auto1.exeption.KeyLenthIsViolatedException;

public class Validator {

    public void validate(String key) {

        Optional<String> optionalKey = Optional.ofNullable(key);
        optionalKey.orElseThrow(() -> new KeyLenthIsViolatedException(""));

        if (key.isBlank() || key.isEmpty() || key.length() > 20) {
            throw new KeyLenthIsViolatedException("Constraint violations, value either empty or exceeds 20 chars");
        }
    }

    public void validate(Integer key) {
        Optional<Integer> optionalKey = Optional.ofNullable(key);
        optionalKey.orElseThrow(() -> new KeyLenthIsViolatedException("Constraint violations, value empty or null."));
    }
}
