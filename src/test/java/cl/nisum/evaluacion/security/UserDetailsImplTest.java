package cl.nisum.evaluacion.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import cl.nisum.evaluacion.models.AuthCredentials;

public class UserDetailsImplTest {

    @Test
    public void userDetailsImplMethodsReturnCorrectValues() {
     
        AuthCredentials authCredentials = new AuthCredentials("password123", "John Doe", "johndoe@example.com");
        
  
        UserDetailsImpl userDetails = new UserDetailsImpl(authCredentials);


        assertEquals("password123", userDetails.getPassword());


        assertEquals("johndoe@example.com", userDetails.getUsername());

  
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        assertTrue(authorities.isEmpty());

        assertTrue(userDetails.isAccountNonExpired());

 
        assertTrue(userDetails.isAccountNonLocked());

      
        assertTrue(userDetails.isCredentialsNonExpired());

        assertTrue(userDetails.isEnabled());

        
        assertEquals("John Doe", userDetails.getNombre());
    }
}
