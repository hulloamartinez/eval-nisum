package cl.nisum.evaluacion.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CallApiExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "An error occurred";
        CallApiException exception = new CallApiException(expectedMessage, "ERROR_CODE");

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testExceptionCode() {
        String expectedCode = "ERROR_CODE";
        CallApiException exception = new CallApiException("An error occurred", expectedCode);

        assertEquals(expectedCode, exception.getCode());
    }

    @Test
    public void testSetCode() {
        String initialCode = "INITIAL_CODE";
        String expectedCode = "NEW_CODE";
        CallApiException exception = new CallApiException("An error occurred", initialCode);

        exception.setCode(expectedCode);
        assertEquals(expectedCode, exception.getCode());
    }
}
