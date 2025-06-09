package com.parking.service;

import java.util.List;

import com.parking.entity.Estacionamiento;

public interface EstacionamientoService {
	List<Estacionamiento> obtenerPorEstado(Estacionamiento.Estado estado);
	Estacionamiento registrarEstacionamiento(Estacionamiento estacionamiento);
	void desocuparEstacionamiento(Integer id);
}
