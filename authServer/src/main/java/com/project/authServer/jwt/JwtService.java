package com.project.authServer.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class JwtService {

    private final String SECRET="hem68iP40p7W5tJjnDEquBo+dQleyTX2KbmMYDPv8n5PdAjTQ6LSh1w0G2tLrJ39";



    public String generateToken(
            UserDetails userDetails
    )
    {
        String userRole=userDetails.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("role",userRole)
                .signWith(setSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key setSigninKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
