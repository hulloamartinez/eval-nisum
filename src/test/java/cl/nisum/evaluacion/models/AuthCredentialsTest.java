package cl.nisum.evaluacion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class AuthCredentialsTest {

    @Test
    public void testAuthCredentialsSettersAndGetters() {
        AuthCredentials authCredentials = new AuthCredentials();

        UUID id = UUID.randomUUID();
        String email = "test@example.com";
        String password = "password123";
        String nombre = "Test User";

        authCredentials.setId(id);
        authCredentials.setEmail(email);
        authCredentials.setPassword(password);
        authCredentials.setNombre(nombre);

        assertEquals(id, authCredentials.getId());
        assertEquals(email, authCredentials.getEmail());
        assertEquals(password, authCredentials.getPassword());
        assertEquals(nombre, authCredentials.getNombre());
    }
    
    @Test
    public void testAuthCredentialsConstructor() {
        UUID id = UUID.randomUUID();
        String password = "password123";
        String nombre = "John Doe";
        String email = "john.doe@example.com";

        AuthCredentials authCredentials = new AuthCredentials(password, nombre, email);
       
        assertEquals(password, authCredentials.getPassword());
        assertEquals(nombre, authCredentials.getNombre());
        assertEquals(email, authCredentials.getEmail());

        
    }
    
}
