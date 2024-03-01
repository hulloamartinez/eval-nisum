package cl.nisum.evaluacion.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.client.ResourceAccessException;

import cl.nisum.evaluacion.dto.ErrorDTO;

@ExtendWith(MockitoExtension.class)
public class ControllerAdviceTest {

    private ControllerAdvice controllerAdvice = new ControllerAdvice();

    @Test
    public void shouldHandleRequestException() {
        String message = "Error message";
        String code = "Error message";
        RequestException ex = new RequestException(message, code);

        ResponseEntity<ErrorDTO> response = controllerAdvice.requestExceptionHandler(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(message, response.getBody().getMessage());
        assertEquals(code, response.getBody().getCode());
    }

    @Test
    public void shouldHandleSQLException() {
        SQLException ex = new SQLException("Database error", "SQLState", 0);

        ResponseEntity<ErrorDTO> response = controllerAdvice.databaseExceptionHandler(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("SQLState", response.getBody().getCode());
        assertEquals("Database error", response.getBody().getMessage());
    }

    @Test
    public void shouldHandleGenericException() {
        Exception ex = new Exception("General error");

        ResponseEntity<ErrorDTO> response = controllerAdvice.databaseExceptionHandler(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().getMessage().contains("General error"));
    }

    @Test
    public void shouldHandleResourceAccessException() {
        ResourceAccessException ex = new ResourceAccessException("Resource error");

        ResponseEntity<ErrorDTO> response = controllerAdvice.ResourceAccessExceptionHandler(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().getMessage().contains("Resource error"));
    }

    @Test
    public void shouldHandleCallApiException() {
        CallApiException ex = new CallApiException("API error", "API_ERROR");

        ResponseEntity<ErrorDTO> response = controllerAdvice.CallApiExceptionHandler(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("API error", response.getBody().getMessage());
    }

    @Test
    public void shouldHandleAuthenticationException() {
        AuthenticationException ex = new AuthenticationException("Authentication failed") {};

        ResponseEntity<ErrorDTO> response = controllerAdvice.handleAuthenticationException(ex);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertTrue(response.getBody().getMessage().contains("Authentication failed"));
    }

    @Test
    public void shouldHandleEmailAlreadyExistsException() {
        EmailAlreadyExistsException ex = new EmailAlreadyExistsException("Email exists");

        ResponseEntity<ErrorDTO> response = controllerAdvice.handleEmailAlreadyExists(ex);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Email exists", response.getBody().getMessage());
    }

    @Test
    public void shouldHandleInvalidEmailException() {
        InvalidEmailException ex = new InvalidEmailException("Invalid email format");

        ResponseEntity<Object> response = controllerAdvice.handleInvalidEmailException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(((ErrorDTO) response.getBody()).getMessage().contains("Invalid email format"));
    }
}
