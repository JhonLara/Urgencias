package com.ceiba.comando;

import java.time.LocalDate;

public class ComandoUrgencia {
	private int idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private boolean esHospitalizacion;

	public ComandoUrgencia(int idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps,
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

	public int getIdPaciente() {
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

	public boolean getEsHospitalizacion() {
		return esHospitalizacion;
	}
}
