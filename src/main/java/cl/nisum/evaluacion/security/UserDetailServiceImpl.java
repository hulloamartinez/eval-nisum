package cl.nisum.evaluacion.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.nisum.evaluacion.models.AuthCredentials;
import cl.nisum.evaluacion.repositories.CredencialesAutenticacionRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private CredencialesAutenticacionRepository userInterface;



    public UserDetailServiceImpl(CredencialesAutenticacionRepository userInterface) {
		this.userInterface = userInterface;
	}



	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		AuthCredentials credenciales = userInterface
                .findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con el email = "+email+" no existe"));
        return new UserDetailsImpl(credenciales);

    }
}
