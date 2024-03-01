package cl.nisum.evaluacion.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    @NotBlank

	private String name;
	

    @NotNull
    @NotBlank
	@Column(name="email", unique = true)
	private String email;


    @NotNull
    @NotBlank
	private String password;
	
	@Column(name="created")
	private String created;
	
	private String modified;

	@Column(name = "last_login")
	private String lastLogin;
	
	private boolean isActive;
	
	private String token;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="user", cascade = CascadeType.ALL)
	private List<Phone> phones;
	
	public Usuario() {
		
	}
	

	public Usuario(String name, String email, String password, List<Phone> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		
	}



	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public List<Phone> getPhones() {
		return phones;
	}



	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", created='" + created + '\'' +
				", modified='" + modified + '\'' +
				", lastLogin='" + lastLogin + '\'' +
				", isActive=" + isActive +
				", token='" + token + '\'' +
				", phones=" + phones +
				'}';
	}
}
