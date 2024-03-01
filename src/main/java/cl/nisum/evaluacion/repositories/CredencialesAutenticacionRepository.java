package cl.nisum.evaluacion.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.nisum.evaluacion.models.AuthCredentials;

@Repository
public interface CredencialesAutenticacionRepository extends JpaRepository<AuthCredentials,UUID>{

	Optional<AuthCredentials> findOneByEmail(String email);
}
