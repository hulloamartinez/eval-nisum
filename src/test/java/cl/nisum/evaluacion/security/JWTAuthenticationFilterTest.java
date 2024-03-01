package cl.nisum.evaluacion.security;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.StringReader;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@ExtendWith(MockitoExtension.class)
public class JWTAuthenticationFilterTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Test
    public void testSuccessfulAuthentication() throws Exception {
       
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);

       
        String jsonCredentials = "{\"email\":\"test@example.com\",\"password\":\"password\"}";
        BufferedReader reader = new BufferedReader(new StringReader(jsonCredentials));
        when(request.getReader()).thenReturn(reader);

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any())).thenReturn(authentication);
       
        Authentication result = jwtAuthenticationFilter.attemptAuthentication(request, response);
        
      
        verify(authenticationManager).authenticate(any());
        
     
    }

    @Test
    public void testUnsuccessfulAuthentication() throws Exception {
       
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

       
        String jsonCredentials = "{\"email\":\"wrong@example.com\",\"password\":\"incorrect\"}";
        BufferedReader reader = new BufferedReader(new StringReader(jsonCredentials));
        when(request.getReader()).thenReturn(reader);

   
        when(authenticationManager.authenticate(any())).thenThrow(new AuthenticationException("Authentication failed") {});

       
        assertThrows(AuthenticationException.class, () -> {
            jwtAuthenticationFilter.attemptAuthentication(request, response);
        });

       
        jwtAuthenticationFilter.unsuccessfulAuthentication(request, response, null);
        
       
    }
}
