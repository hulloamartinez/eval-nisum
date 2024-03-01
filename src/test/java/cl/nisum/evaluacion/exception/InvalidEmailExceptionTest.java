package cl.nisum.evaluacion.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvalidEmailExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "Invalid email format.";
        InvalidEmailException exception = new InvalidEmailException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
