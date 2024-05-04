package com.project.authServer.services;


import com.project.authServer.http.AuthRequest;
import com.project.authServer.http.AuthResponse;
import com.project.authServer.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;


    public AuthResponse authenticate(AuthRequest request) {
        // First, we need to authenticate the logIn process
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        // Getting that userdetails out of database using username
        var user= userDetailsService.loadUserByUsername(request.getUsername());

        // Authenicating the token
        var jwtToken= jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
