package com.lucasramallo.authenticationjwt.repository;

import com.lucasramallo.authenticationjwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository                         // Indicamos que maneja la comunicacion con la BD
public interface UserRepository extends JpaRepository<User,Long>{

  //buscamos un usuario por nombre de usuario
  Optional<User> findByUsername(String username);

  //Buscamos usuario por email
  Optional<User> findByEmail(String email);


  //Verificamos si existe un usuario por email o username
  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
}
