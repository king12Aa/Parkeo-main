package com.parking.service;

import com.parking.entity.Estacionamiento;
import com.parking.repository.EstacionamientoRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TiempoLibreService {

    @Autowired
    private EstacionamientoRepository estacionamientoRepository;

    @Scheduled(fixedRate = 5000) // cada 5 segundos
    public void actualizarTiempoLibre() {
        List<Estacionamiento> espaciosLibres = estacionamientoRepository.findByEstado(Estacionamiento.Estado.libre);
        for (Estacionamiento espacio : espaciosLibres) {
            Integer tiempoActual = espacio.getTiempoLibre();
            espacio.setTiempoLibre(tiempoActual != null ? tiempoActual + 5 : 5);
            estacionamientoRepository.saveAll(espaciosLibres);	
        }
        estacionamientoRepository.flush();
    }
}
