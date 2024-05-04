package com.project.workflow.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class JwtService {

    private final String secret= "hem68iP40p7W5tJjnDEquBo+dQleyTX2KbmMYDPv8n5PdAjTQ6LSh1w0G2tLrJ39";


    public String getUserName(String jwtToken) {

        return extractClaim(jwtToken, Claims::getSubject);
    }

    public String getUserRole(String jwtToken) {
        return extractAllClaims(jwtToken).get("role", String.class);
    }


    private boolean isTokenExpired(String token) {

        return extractExpirationDate(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpirationDate(String token){

        return extractClaim(token, Claims::getExpiration);
    }



    public Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigninKey() {
        byte[] keyBytes= Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    //Extracting a specified single claim
    // This method will return a single claim
    public <T> T extractClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims= extractAllClaims(token);
        return claimResolver.apply(claims);
    }
}
