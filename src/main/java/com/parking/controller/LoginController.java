package com.parking.controller;

import com.parking.entity.Usuario;
import com.parking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String correo, @RequestParam String contrasena) {
        Usuario usuario = loginService.login(correo, contrasena);
        if (usuario != null) {
            return ResponseEntity.ok(usuario); // o retornar solo ID/nombre
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}

