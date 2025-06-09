package com.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estacionamiento")
public class Estacionamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estacionamiento")
	private Integer idEstacionamiento;

	@Column(name = "numero_espacio", nullable = false, unique = true)
	private Integer numeroEspacio;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado", nullable = false)
	private Estado estado = Estado.libre;

	@Column(name = "tiempo_libre", nullable = false)
	private Integer tiempoLibre = 0;  // Valor predeterminado para evitar el valor null

	public Estacionamiento() {
		// Constructor por defecto requerido por JPA
	}

	public Estacionamiento(Integer idEstacionamiento, Integer numeroEspacio, Estado estado, Integer tiempoLibre) {
		this.idEstacionamiento = idEstacionamiento;
		this.numeroEspacio = numeroEspacio;
		this.estado = estado;
		this.tiempoLibre = 0;
	}

	public Integer getIdEstacionamiento() {
		return idEstacionamiento;
	}

	public void setIdEstacionamiento(Integer idEstacionamiento) {
		this.idEstacionamiento = idEstacionamiento;
	}

	public Integer getNumeroEspacio() {
		return numeroEspacio;
	}

	public void setNumeroEspacio(Integer numeroEspacio) {
		this.numeroEspacio = numeroEspacio;
	}

	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getTiempoLibre() {
		return tiempoLibre;
	}

	public void setTiempoLibre(Integer tiempoLibre) {
		this.tiempoLibre = tiempoLibre;
	}

	public enum Estado {
		libre,
		ocupado
	}
}

