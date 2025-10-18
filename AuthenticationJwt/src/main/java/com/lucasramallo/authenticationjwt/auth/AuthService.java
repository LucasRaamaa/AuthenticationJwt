package com.lucasramallo.authenticationjwt.auth;

import com.lucasramallo.authenticationjwt.auth.dto.*;
import com.lucasramallo.authenticationjwt.config.JwtService;
import com.lucasramallo.authenticationjwt.entities.User;
import com.lucasramallo.authenticationjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthResponse register(RegisterRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) {
      throw new RuntimeException("El nombre de usuario ya está en uso");
    }
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new RuntimeException("El email ya está en uso");
    }

    var user = User.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role("USER")
        .build();

    userRepository.save(user);

    var jwtToken = jwtService.generateToken(user.getUsername());
    return AuthResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthResponse login(LoginRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUsername(),
            request.getPassword()
        )
    );

    var user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    var jwtToken = jwtService.generateToken(user.getUsername());
    return AuthResponse.builder()
        .token(jwtToken)
        .build();
  }
}