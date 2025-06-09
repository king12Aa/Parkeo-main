// IngresoController.java
package com.parking.controller;

import com.parking.entity.Ingreso;
import com.parking.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;
    
    @GetMapping
    public ResponseEntity<?> listarIngresos(){
    	return ResponseEntity.ok(ingresoService.listarTodos());
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarIngreso(@RequestBody Ingreso ingreso, @RequestParam("usuarioId") Long usuarioId){
    	ingresoService.registrarIngreso(ingreso, usuarioId);
    	return ResponseEntity.status(HttpStatus.CREATED).body("Ingreso registrado exitosamente");
    }
    
    public ResponseEntity<?> registrarSalida(@PathVariable Integer id){
    	boolean actualizado = ingresoService.registrarSalida(id);
    	if (actualizado) {
			return ResponseEntity.ok("Salida registrada.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingreso no encontrado o ya tiene salida."); 
		}
    }

}
