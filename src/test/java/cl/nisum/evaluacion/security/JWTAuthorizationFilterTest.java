package cl.nisum.evaluacion.security;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import cl.nisum.evaluacion.utils.TokenUtils;

@ExtendWith(MockitoExtension.class)
public class JWTAuthorizationFilterTest {

	@Test
	public void shouldSetAuthenticationWhenTokenIsValid() throws ServletException, IOException {
		try (MockedStatic<TokenUtils> mockedStatic = Mockito.mockStatic(TokenUtils.class)) {

			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			FilterChain filterChain = mock(FilterChain.class);

			String validToken = "Bearer validToken";
			when(request.getHeader("Authorization")).thenReturn(validToken);

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken("user", null, null);
			mockedStatic.when(() -> TokenUtils.getAuthentication(anyString())).thenReturn(authToken);

			SecurityContext securityContext = mock(SecurityContext.class);
			SecurityContextHolder.setContext(securityContext);

			JWTAuthorizationFilter filter = new JWTAuthorizationFilter();
			filter.doFilterInternal(request, response, filterChain);

			verify(securityContext).setAuthentication(authToken);
			verify(filterChain).doFilter(request, response);
		}
	}

	@Test
	public void shouldNotSetAuthenticationWhenTokenIsInvalid() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		FilterChain filterChain = mock(FilterChain.class);

		when(request.getHeader("Authorization")).thenReturn(null);

		SecurityContext securityContext = mock(SecurityContext.class);
		SecurityContextHolder.setContext(securityContext);

		JWTAuthorizationFilter filter = new JWTAuthorizationFilter();
		filter.doFilterInternal(request, response, filterChain);

		verify(securityContext, never()).setAuthentication(any());
		verify(filterChain).doFilter(request, response);
	}
}
