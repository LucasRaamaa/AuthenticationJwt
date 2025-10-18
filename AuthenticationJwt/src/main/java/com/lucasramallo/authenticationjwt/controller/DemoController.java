package com.lucasramallo.authenticationjwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
  @GetMapping
  public ResponseEntity<String>demo(){
    return ResponseEntity.ok("Acceso Permitido con JWT valido.!!");
  }

}
