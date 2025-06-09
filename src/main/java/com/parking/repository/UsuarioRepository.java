package com.parking.repository;
import com.parking.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreoAndContrasena(String correo, String contrasena);

}

