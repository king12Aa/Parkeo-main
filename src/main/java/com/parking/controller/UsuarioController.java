// UsuarioController.java
package com.parking.controller;

import com.parking.entity.Usuario;
import com.parking.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario){
		usuarioService.registrar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body("usuario regitrado correctamente");
	}
	
	@GetMapping("/roles")
	public ResponseEntity<Usuario.Rol[]> obtenerRoles(){
		return ResponseEntity.ok(Usuario.Rol.values());
	}
	
}
