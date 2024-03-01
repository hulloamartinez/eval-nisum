package cl.nisum.evaluacion.dto;

import java.util.UUID;

public class UsuarioResponseDTO {
	
    private UUID id;

	private String created;
	
	private String modified;

	private String lastLogin;
	
	private boolean isActive;
	
	private String token;

	public UsuarioResponseDTO(UUID id, String created, String modified, String lastLogin, boolean isActive,
			String token) {
		super();
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.isActive = isActive;
		this.token = token;
	}

	public UsuarioResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
