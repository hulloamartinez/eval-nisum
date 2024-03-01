package cl.nisum.evaluacion.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RequestExceptionTest {

    @Test
    public void testExceptionMessageAndCode() {
        String expectedMessage = "An error occurred during the request.";
        String expectedCode = "REQUEST_ERROR";

        RequestException exception = new RequestException(expectedMessage, expectedCode);

        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(expectedCode, exception.getCode());
    }

    @Test
    public void testSetCode() {
        String expectedMessage = "An error occurred during the request.";
        String initialCode = "INIT_CODE";
        String newCode = "NEW_CODE";

        RequestException exception = new RequestException(expectedMessage, initialCode);
        exception.setCode(newCode);

        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(newCode, exception.getCode());
    }
}
