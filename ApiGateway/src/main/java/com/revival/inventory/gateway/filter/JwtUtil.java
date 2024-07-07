package com.revival.inventory.gateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private static final String SECRET_KEY = "5a5c499df9c21c0e26e9b40c6e6106d327123c9645751bfa4c2ae2c18adbe61e0cf4eaae210238fe53c9e0e494937da429fb04d91d2b914e9f904418435c1b79";
    //private final UserServiceClient userServiceClient;

    public boolean isTokenValid(String jwt) {
        String userName = extractUserEmail(jwt);
        //String email = userServiceClient.getUserByEmail(userName).getEmail();
        return isTokenExpired(jwt);
    }

    private boolean isTokenExpired(String token) {
        Date expirationDate = extractClaims(token, Claims::getExpiration);
        return expirationDate.after(new Date());
    }

    public String extractUserEmail(String jwt) {
        return extractClaims(jwt, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
