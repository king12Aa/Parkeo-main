package com.parking.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.entity.Estacionamiento;
import com.parking.entity.Ingreso;
import com.parking.entity.Usuario;
import com.parking.repository.EstacionamientoRepository;
import com.parking.repository.IngresoRepository;
import com.parking.repository.UsuarioRepository;
import com.parking.service.IngresoService;

@Service
public class IngresoServiceImpl implements IngresoService{
	
	@Autowired
	private IngresoRepository ingresoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EstacionamientoRepository estacionamientoRepository;

	@Override
	public List<Ingreso> listarTodos() {
		// TODO Auto-generated method stub
		return ingresoRepository.findAll();
	}

	@Override
	public void registrarIngreso(Ingreso ingreso, Long usuarioId) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
		
		ingreso.setUsuario(usuario);
		ingreso.setFechaHoraEntrada(LocalDateTime.now());
		
		Estacionamiento estacionamiento = ingreso.getEstacionamiento();
		estacionamiento.setEstado(Estacionamiento.Estado.ocupado);
		
		estacionamientoRepository.save(estacionamiento);
		ingresoRepository.save(ingreso);
	}

	@Override
	public boolean registrarSalida(Integer id) {
		// TODO Auto-generated method stub
		Ingreso ingreso = ingresoRepository.findById(id).orElse(null);
		
		if (ingreso != null && ingreso.getFechaHoraEntrada()==null) {
			ingreso.setFechaHoraSalida(LocalDateTime.now());
			
			Estacionamiento estacionamiento = ingreso.getEstacionamiento();
			estacionamiento.setEstado(Estacionamiento.Estado.libre);
			
			estacionamientoRepository.save(estacionamiento);
			ingresoRepository.save(ingreso);
			
			return true;
		}
		return false;
	}

}
