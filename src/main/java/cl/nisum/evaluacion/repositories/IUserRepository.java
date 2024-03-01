package cl.nisum.evaluacion.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.nisum.evaluacion.models.Usuario;

@Repository
public interface IUserRepository extends JpaRepository<Usuario,UUID>{
	
	Optional<Usuario> findOneByEmail(String email);

}
