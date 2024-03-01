package cl.nisum.evaluacion.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.nisum.evaluacion.dto.UsuarioResponseDTO;
import cl.nisum.evaluacion.exception.EmailAlreadyExistsException;
import cl.nisum.evaluacion.exception.InvalidEmailException;
import cl.nisum.evaluacion.models.Usuario;
import cl.nisum.evaluacion.repositories.IUserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void saveUsuarioShouldThrowEmailAlreadyExistsException() {
        Usuario user = new Usuario();
        user.setEmail("test@test.com");

        when(userRepository.findOneByEmail(anyString())).thenReturn(Optional.of(user));

        assertThrows(EmailAlreadyExistsException.class, () -> userService.saveUsuario(user, "dummyToken"));
    }

    @Test
    public void saveUsuarioShouldSaveUserWhenEmailIsValid() {
        Usuario user = new Usuario();
        user.setId(UUID.randomUUID());
        user.setEmail("valid@test.com");
        user.setCreated("now");
        user.setModified("now");
        user.setLastLogin("now");
        user.setActive(true);
        user.setToken("dummyToken");

        when(userRepository.findOneByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(Usuario.class))).thenReturn(user);

        UsuarioResponseDTO result = userService.saveUsuario(user, "dummyToken");

        assertNotNull(result);
        assertEquals(user.getEmail(), "valid@test.com");
        assertEquals(user.getToken(), result.getToken());
        assertTrue(result.isActive());
    }

    @Test
    public void saveUsuarioShouldThrowInvalidEmailExceptionWhenEmailIsInvalid() {
        Usuario user = new Usuario();
        user.setEmail("invalid");

        // Asegúrate de que la validación de email está correctamente implementada para que este test sea válido.
        assertThrows(InvalidEmailException.class, () -> userService.saveUsuario(user, "dummyToken"));
    }
}
