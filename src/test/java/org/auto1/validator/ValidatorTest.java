package org.auto1.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.auto1.exeption.KeyLenthIsViolatedException;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void givenTooLongKeyWhenValidateThenThrowExpection() {
        // given
        Validator validator = new Validator();
        // when
        String key = "1234567880123456789012345";
        // then
        assertThrows(KeyLenthIsViolatedException.class, () -> validator.validate(key));
    }

}
