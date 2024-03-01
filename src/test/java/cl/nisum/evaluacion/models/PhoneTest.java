package cl.nisum.evaluacion.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class PhoneTest {

    @Test
    public void testPhoneSettersAndGetters() {
        Phone phone = new Phone();

        UUID id = UUID.randomUUID();
        String number = "123456789";
        String citycode = "1";
        String contrycode = "57";
        Usuario user = new Usuario(); // Asume que tienes un constructor por defecto o adecuado.

        phone.setId(id);
        phone.setNumber(number);
        phone.setCitycode(citycode);
        phone.setContrycode(contrycode);
        phone.setUser(user);

        assertEquals(id, phone.getId());
        assertEquals(number, phone.getNumber());
        assertEquals(citycode, phone.getCitycode());
        assertEquals(contrycode, phone.getContrycode());
        assertEquals(user, phone.getUser());
    }
    

    @Test
    public void testPhoneDefaultConstructor() {
        Phone phone = new Phone();
        // No hay valores para verificar directamente después de la construcción, 
        // pero se puede verificar que el objeto no es nulo.
        assertEquals(phone.getClass(), Phone.class);
    }

    @Test
    public void testPhoneParameterizedConstructorWithoutUser() {
        String number = "123456789";
        String citycode = "1";
        String contrycode = "57";

        Phone phone = new Phone(number, citycode, contrycode);

        assertEquals(number, phone.getNumber());
        assertEquals(citycode, phone.getCitycode());
        assertEquals(contrycode, phone.getContrycode());
        // El usuario se espera que sea nulo ya que no se ha proporcionado.
        assertEquals(null, phone.getUser());
    }

    @Test
    public void testPhoneParameterizedConstructorWithUser() {
        String number = "987654321";
        String citycode = "9";
        String contrycode = "81";
        Usuario user = new Usuario(); // Se asume que Usuario tiene un constructor por defecto.

        Phone phone = new Phone(number, citycode, contrycode, user);

        assertEquals(number, phone.getNumber());
        assertEquals(citycode, phone.getCitycode());
        assertEquals(contrycode, phone.getContrycode());
        assertEquals(user, phone.getUser());
    }
}
