package com.parking.controller;

import com.parking.service.EstacionamientoService;
import com.parking.entity.Estacionamiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estacionamientos")
public class EstacionamientoController {

    @Autowired
    private EstacionamientoService estacionamientoService;
    
    @GetMapping("/libres")
    public List<Estacionamiento> obtenerEspaciosLibres() {
        return estacionamientoService.obtenerPorEstado(Estacionamiento.Estado.libre);
    }

    @GetMapping("/ocupados")
    public List<Estacionamiento> obtenerEspaciosOcupados() {
        return estacionamientoService.obtenerPorEstado(Estacionamiento.Estado.ocupado);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarEstacionamiento(@RequestBody Estacionamiento est) {
        try {
            Estacionamiento registrado = estacionamientoService.registrarEstacionamiento(est);
            return ResponseEntity.ok(registrado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    

    @PostMapping("/desocupar/{id}")
    public ResponseEntity<?> desocupar(@PathVariable Integer id) {
        estacionamientoService.desocuparEstacionamiento(id);
        return ResponseEntity.ok().build();
    }

}
    
