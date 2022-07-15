package pl.lotto;

import org.junit.jupiter.api.Test;
import pl.lotto.validator.ValidatorOfRange;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorOfRangeTest {

    @Test
    void shouldReturnTrueForSix(){
        ValidatorOfRange validator = new ValidatorOfRange(1,99);
        assertTrue(validator.validate(6));
    }

    @Test
    void shouldReturnFalseForNegativeNumber(){
        ValidatorOfRange validator = new ValidatorOfRange(1,99);
        assertFalse(validator.validate(-5));
    }
}
