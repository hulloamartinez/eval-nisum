package cl.nisum.evaluacion.utils;

import cl.nisum.evaluacion.dto.UsuarioResponseDTO;
import cl.nisum.evaluacion.models.Usuario;

public class MapperUtils {

	public static UsuarioResponseDTO mapResponse(Usuario user) {
		
		UsuarioResponseDTO response = new UsuarioResponseDTO();
		
		response.setId(user.getId());
		response.setCreated(user.getCreated());
		response.setModified(user.getModified());
		response.setLastLogin(user.getLastLogin());
		response.setToken(user.getToken());
		response.setActive(user.isActive());
		
		
		return response;
		
	}
}
