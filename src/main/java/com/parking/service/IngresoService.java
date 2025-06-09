package com.parking.service;

import java.util.List;

import com.parking.entity.Ingreso;

public interface IngresoService {
    List<Ingreso> listarTodos();
    void registrarIngreso(Ingreso ingreso, Long usuarioId);
    boolean registrarSalida(Integer id);
}
