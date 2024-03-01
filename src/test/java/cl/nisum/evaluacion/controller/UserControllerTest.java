package cl.nisum.evaluacion.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import cl.nisum.evaluacion.dto.UsuarioResponseDTO;
import cl.nisum.evaluacion.models.Usuario;
import cl.nisum.evaluacion.services.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser
    public void createShouldReturnCreatedWhenValidRequest() throws Exception {
        Usuario user = new Usuario();
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();

        when(userService.saveUsuario(any(Usuario.class), anyString())).thenReturn(responseDTO);

        mockMvc.perform(post("/api/v1/user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"user@example.com\",\"password\":\"password\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void createShouldReturnUnauthorizedWhenTokenIsMissing() throws Exception {
        mockMvc.perform(post("/api/v1/user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"user@example.com\",\"password\":\"password\"}"))
                .andExpect(status().isUnauthorized());
    }
}
