package cl.nisum.evaluacion.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ErrorDTOTest {

    @Test
    public void givenErrorDTO_whenSetCode_thenCorrectCodeIsReturned() {
        ErrorDTO errorDTO = new ErrorDTO(null, null);
        errorDTO.setCode("404");
        assertEquals("404", errorDTO.getCode());
    }

    @Test
    public void givenErrorDTO_whenSetMessage_thenCorrectMessageIsReturned() {
        ErrorDTO errorDTO = new ErrorDTO(null, null);
        errorDTO.setMessage("Not Found");
        assertEquals("Not Found", errorDTO.getMessage());
    }
}
