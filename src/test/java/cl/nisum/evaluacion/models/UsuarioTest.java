package cl.nisum.evaluacion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void givenUsuario_whenSetters_thenCorrectValuesRetrieved() {
        UUID id = UUID.randomUUID();
        String name = "Test Name";
        String email = "test@example.com";
        String password = "securePassword";
        String created = "2023-01-01T00:00:00";
        String modified = "2023-01-02T00:00:00";
        String lastLogin = "2023-01-03T00:00:00";
        boolean isActive = true;
        String token = "dummyToken";
        Phone phone = new Phone(); // Asume que tienes un constructor adecuado o setters.
        List<Phone> phones = Collections.singletonList(phone);

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setName(name);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setCreated(created);
        usuario.setModified(modified);
        usuario.setLastLogin(lastLogin);
        usuario.setActive(isActive);
        usuario.setToken(token);
        usuario.setPhones(phones);

        assertEquals(id, usuario.getId());
        assertEquals(name, usuario.getName());
        assertEquals(email, usuario.getEmail());
        assertEquals(password, usuario.getPassword());
        assertEquals(created, usuario.getCreated());
        assertEquals(modified, usuario.getModified());
        assertEquals(lastLogin, usuario.getLastLogin());
        assertEquals(isActive, usuario.isActive());
        assertEquals(token, usuario.getToken());
        assertEquals(phones, usuario.getPhones());
    }
    
    @Test
    public void testUsuarioParameterizedConstructor() {
        String name = "Test Name";
        String email = "test@example.com";
        String password = "testPassword";
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone());  

        Usuario usuario = new Usuario(name, email, password, phones);

        assertEquals(name, usuario.getName());
        assertEquals(email, usuario.getEmail());
        assertEquals(password, usuario.getPassword());
        assertEquals(phones, usuario.getPhones());
        
    }

    @Test
    public void testToString() {
        Usuario usuario = new Usuario();
        UUID id = UUID.randomUUID();
        String name = "Test User";
        String email = "user@test.com";
        String password = "securePassword";
        String created = "2021-01-01T12:00:00";
        String modified = "2021-01-02T12:00:00";
        String lastLogin = "2021-01-03T12:00:00";
        boolean isActive = true;
        String token = "someToken";
        List<Phone> phones = new ArrayList<>(); // Asumiendo que Phone tiene un toString adecuado

        usuario.setId(id);
        usuario.setName(name);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setCreated(created);
        usuario.setModified(modified);
        usuario.setLastLogin(lastLogin);
        usuario.setActive(isActive);
        usuario.setToken(token);
        usuario.setPhones(phones);

        String expected = "Usuario{id=" + id +
                          ", name='" + name + '\'' +
                          ", email='" + email + '\'' +
                          ", password='" + password + '\'' +
                          ", created='" + created + '\'' +
                          ", modified='" + modified + '\'' +
                          ", lastLogin='" + lastLogin + '\'' +
                          ", isActive=" + isActive +
                          ", token='" + token + '\'' +
                          ", phones=" + phones + '}';
        
        assertEquals(expected, usuario.toString());
    }
    
}
