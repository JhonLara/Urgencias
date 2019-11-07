package com.ceiba.urgencias.aplicacion.comando;

import java.time.LocalDate;

public class ComandoUrgencia {

	private Long idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private boolean esHospitalizacion;

	public ComandoUrgencia(Long idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps,
			boolean esHospitalizacion) {
		super();
		this.idPaciente = idPaciente;
		this.nombrePersona = nombrePersona;
		this.fechaIngreso = fechaIngreso;
		this.eps = eps;
		this.esHospitalizacion = esHospitalizacion;
	}

	public ComandoUrgencia() {
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public String getEps() {
		return eps;
	}

	public boolean isEsHospitalizacion() {
		return esHospitalizacion;
	}
}
