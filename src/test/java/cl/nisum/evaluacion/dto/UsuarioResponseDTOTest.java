package cl.nisum.evaluacion.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class UsuarioResponseDTOTest {

    @Test
    public void testUsuarioResponseDTOSettersAndGetters() {
        UUID id = UUID.randomUUID();
        String created = "2023-01-01T00:00:00";
        String modified = "2023-01-02T00:00:00";
        String lastLogin = "2023-01-03T00:00:00";
        boolean isActive = true;
        String token = "dummyToken";

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(id);
        usuarioResponseDTO.setCreated(created);
        usuarioResponseDTO.setModified(modified);
        usuarioResponseDTO.setLastLogin(lastLogin);
        usuarioResponseDTO.setActive(isActive);
        usuarioResponseDTO.setToken(token);

        assertEquals(id, usuarioResponseDTO.getId());
        assertEquals(created, usuarioResponseDTO.getCreated());
        assertEquals(modified, usuarioResponseDTO.getModified());
        assertEquals(lastLogin, usuarioResponseDTO.getLastLogin());
        assertEquals(isActive, usuarioResponseDTO.isActive());
        assertEquals(token, usuarioResponseDTO.getToken());
    }
}
