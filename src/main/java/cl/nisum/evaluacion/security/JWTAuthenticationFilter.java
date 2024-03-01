package cl.nisum.evaluacion.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.nisum.evaluacion.models.AuthCredentials;
import cl.nisum.evaluacion.utils.TokenUtils;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {



	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		AuthCredentials authCredentials = null;
		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);

		} catch (IOException ex) {
			logger.error("Error al procesar las credenciales de autenticación", ex);
		}

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				authCredentials.getEmail(), authCredentials.getPassword(), Collections.emptyList());

		return getAuthenticationManager().authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();


		String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());

	
		response.addHeader("Authorization", "Bearer " + token);


		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		out.print(mapper.writeValueAsString(Collections.singletonMap("token", "Bearer " + token)));
		out.flush();
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		super.unsuccessfulAuthentication(request, response, failed);
	}
}
