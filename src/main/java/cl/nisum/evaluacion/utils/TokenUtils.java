package cl.nisum.evaluacion.utils;


import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "45y5reVf5gd8Hg55fghGGhjtr5rr5r44824d";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;


    public static String createToken(String nombre, String email){

        long exprirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;

        Date expirationDate = new Date(System.currentTimeMillis()+exprirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);


return Jwts.builder()
        .setSubject(email)
        .setExpiration(expirationDate)
        .addClaims(extra)
        .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
        .compact();

    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
    try{
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String email = claims.getSubject();

        return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
    }catch (JwtException ex){
        return null;
    }
    }

}
