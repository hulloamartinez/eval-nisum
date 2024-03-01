package cl.nisum.evaluacion.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import cl.nisum.evaluacion.dto.ErrorDTO;



@RestControllerAdvice
public class ControllerAdvice {
	

	@ExceptionHandler(RequestException.class)
	public ResponseEntity <ErrorDTO> requestExceptionHandler(RequestException ex){
		
		ErrorDTO error = new ErrorDTO(ex.getMessage(),ex.getCode());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = SQLException.class)
	public ResponseEntity <ErrorDTO> databaseExceptionHandler(SQLException ex){
		
		ErrorDTO error = new ErrorDTO(ex.getSQLState(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({RuntimeException.class, Exception.class})
	public ResponseEntity <ErrorDTO> databaseExceptionHandler(Exception ex){
		
		ErrorDTO error = new ErrorDTO(ex.getClass().toString(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceAccessException.class)
		public ResponseEntity <ErrorDTO> ResourceAccessExceptionHandler(ResourceAccessException ex){

			ErrorDTO error = new ErrorDTO(ex.getClass().toString(), ex.getMessage());

			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CallApiException.class)
	public ResponseEntity <ErrorDTO> CallApiExceptionHandler(CallApiException ex){

		ErrorDTO error = new ErrorDTO(ex.getClass().toString(), ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  // 401 Error
    public ResponseEntity<ErrorDTO> handleAuthenticationException(AuthenticationException ex) {
        ErrorDTO error = new ErrorDTO("Authentication error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        ErrorDTO error = new ErrorDTO("Email Registration Error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);  // HttpStatus.CONFLICT = 409
    }
    
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Object> handleInvalidEmailException(InvalidEmailException ex) {
    	ErrorDTO error = new ErrorDTO("Email format Error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

