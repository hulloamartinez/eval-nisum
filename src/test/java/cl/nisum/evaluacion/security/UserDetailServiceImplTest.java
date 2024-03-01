package cl.nisum.evaluacion.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cl.nisum.evaluacion.models.AuthCredentials;
import cl.nisum.evaluacion.repositories.CredencialesAutenticacionRepository;

@ExtendWith(MockitoExtension.class)
public class UserDetailServiceImplTest {

    @Mock
    private CredencialesAutenticacionRepository userInterface;

    @InjectMocks
    private UserDetailServiceImpl userDetailsService;

    @Test
    public void loadUserByUsernameShouldReturnUserDetails() {
        String email = "user@example.com";
        AuthCredentials authCredentials = new AuthCredentials("password", "User", email);

        when(userInterface.findOneByEmail(email)).thenReturn(Optional.of(authCredentials));

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        assertNotNull(userDetails);
        assertEquals(email, userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
    }

    @Test
    public void loadUserByUsernameShouldThrowUsernameNotFoundException() {
        String email = "nonexistent@example.com";

        when(userInterface.findOneByEmail(email)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(email);
        });
    }
}
