package cl.nisum.evaluacion.services;

import org.springframework.stereotype.Service;

import cl.nisum.evaluacion.dto.UsuarioResponseDTO;
import cl.nisum.evaluacion.exception.EmailAlreadyExistsException;
import cl.nisum.evaluacion.exception.InvalidEmailException;
import cl.nisum.evaluacion.models.Usuario;
import cl.nisum.evaluacion.repositories.IUserRepository;
import cl.nisum.evaluacion.utils.DataTimeUtils;
import cl.nisum.evaluacion.utils.MapperUtils;
import cl.nisum.evaluacion.utils.Validation;

@Service
public class UserService {

	private IUserRepository userRepository;

	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UsuarioResponseDTO saveUsuario(Usuario user, String token) {
		
        if (!Validation.validateEmail(user.getEmail())) {
            throw new InvalidEmailException("Formato inválido, por favor revise.");
        }

		if (userRepository.findOneByEmail(user.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException("El correo ya está registrado");
		}
		user.setCreated(DataTimeUtils.fechaActual());
		user.setLastLogin(DataTimeUtils.fechaActual());
		user.setModified(DataTimeUtils.fechaActual());
		user.setToken(token);
		user.setActive(true);

		return MapperUtils.mapResponse(userRepository.save(user));
	}

}
