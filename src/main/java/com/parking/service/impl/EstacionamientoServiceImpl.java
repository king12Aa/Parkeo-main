package com.parking.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parking.entity.Estacionamiento;
import com.parking.repository.EstacionamientoRepository;
import com.parking.service.EstacionamientoService;

@Service
public class EstacionamientoServiceImpl implements EstacionamientoService{
	
	@Autowired
	private EstacionamientoRepository estacionamientoRepository;

	@Override
	public List<Estacionamiento> obtenerPorEstado(Estacionamiento.Estado estado) {
		// TODO Auto-generated method stub
		return estacionamientoRepository.findByEstado(estado);
	}

	@Override
	public Estacionamiento registrarEstacionamiento(Estacionamiento estacionamiento) {
		// TODO Auto-generated method stub
		Optional<Estacionamiento> existente = estacionamientoRepository.findByNumeroEspacio(estacionamiento.getNumeroEspacio());
		
		if (existente.isPresent()) {
			Estacionamiento espacio = existente.get();
			if (espacio.getEstado() == Estacionamiento.Estado.ocupado) {
				throw new RuntimeException("Este espacio ya está ocupado");
			}
			espacio.setEstado(Estacionamiento.Estado.ocupado);
			espacio.setTiempoLibre(0);
			return estacionamientoRepository.save(espacio);
		}
		
		estacionamiento.setEstado(Estacionamiento.Estado.ocupado);
		return null;
	}
	
	@Override
	public void desocuparEstacionamiento(Integer id) {
		// TODO Auto-generated method stub
		estacionamientoRepository.findById(id).ifPresent(estacionamiento -> {
			estacionamiento.setEstado(Estacionamiento.Estado.libre);
			estacionamiento.setTiempoLibre(0);
			estacionamientoRepository.save(estacionamiento);
		});
	}
	
}
