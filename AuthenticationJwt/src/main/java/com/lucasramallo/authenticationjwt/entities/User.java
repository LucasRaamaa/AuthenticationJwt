package com.lucasramallo.authenticationjwt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data                                 //genera getter/setter/toString automaticamente
@NoArgsConstructor                    //constructor vacio
@AllArgsConstructor                   //Constructor con todos los campos
@Entity                               //Marca la clase como tabla en la BD
@Table(name = "users");               // Nombre de la tabla de MySQL
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  private String role; // Ej: "User" o "ADMIN"
}
