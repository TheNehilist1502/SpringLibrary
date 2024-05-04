package com.project.authServer.http;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest{
    String username;
    String password;
}
