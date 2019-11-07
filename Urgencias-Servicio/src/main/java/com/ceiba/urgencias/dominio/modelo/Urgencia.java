package com.ceiba.urgencias.dominio.modelo;

import java.time.LocalDate;

public class Urgencia {

	private Long idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private boolean esHospitalizacion;

	public Urgencia() {
	}

	public Urgencia(Long idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps,
			boolean esHospitalizacion) {
		super();
		this.idPaciente = idPaciente;
		this.nombrePersona = nombrePersona;
		this.fechaIngreso = fechaIngreso;
		this.eps = eps;
		this.esHospitalizacion = esHospitalizacion;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public boolean isEsHospitalizacion() {
		return esHospitalizacion;
	}

	public void setEsHospitalizacion(boolean esHospitalizacion) {
		this.esHospitalizacion = esHospitalizacion;
	}

}
