package com.project.authServer.controllers;

import com.project.authServer.http.AuthRequest;
import com.project.authServer.http.AuthResponse;
import com.project.authServer.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/controller")
public class AuthController {

    private final AuthService authService;

    @GetMapping
    public @ResponseBody String getController() {
        return "Controller";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.authenticate(authRequest));
    }
}
