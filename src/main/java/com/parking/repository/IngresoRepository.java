// IngresoRepository.java
package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parking.entity.Ingreso;

public interface IngresoRepository extends JpaRepository<Ingreso, Integer> {
}
