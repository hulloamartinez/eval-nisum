package cl.nisum.evaluacion.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.nisum.evaluacion.dto.UsuarioResponseDTO;
import cl.nisum.evaluacion.models.Usuario;
import cl.nisum.evaluacion.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	private UserService userService;
	
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}



    @PostMapping("/")
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody @Valid Usuario user, @RequestHeader("Authorization") String token) {

        if (token == null || !token.startsWith("Bearer ")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 
        }

        UsuarioResponseDTO createdUser = this.userService.saveUsuario(user, token);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


}
