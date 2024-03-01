package cl.nisum.evaluacion.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmailAlreadyExistsExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "This email is already registered.";
        EmailAlreadyExistsException exception = new EmailAlreadyExistsException(expectedMessage);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
