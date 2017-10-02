package calculator.validators;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    Validator validator = new Validator();
    private String inputText;

    @Test
    public void isNumeric() throws Exception {
        inputText = "12.2";
        assertTrue(validator.isNumeric(inputText));
    }

    @Test
    public void isNotNumeric_1() throws Exception {
        inputText = "12-2";
        assertFalse(validator.isNumeric(inputText));
    }

    @Test
    public void isNotNumeric_2() throws Exception {
        inputText = "asdf1.0qw-1";
        assertFalse(validator.isNumeric(inputText));
    }

    @Test
    public void isAcceptableLengthFalse() throws Exception {
        String value = "464563456345634563456435634563456435634563";
        assertFalse(validator.isAcceptableLength(value));
    }

    @Test
    public void isAcceptableLengthTrue() throws Exception {
        String value = "464563";
        assertTrue(validator.isAcceptableLength(value));
    }

}