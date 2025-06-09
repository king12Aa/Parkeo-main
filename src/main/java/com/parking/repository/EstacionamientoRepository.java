package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.entity.Estacionamiento;

import java.util.List;
import java.util.Optional;

public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Integer> {
    List<Estacionamiento> findByEstado(Estacionamiento.Estado estado);
    Optional<Estacionamiento> findByNumeroEspacio(int numeroEspacio);


}
