package com.ceiba.aplicacion.comando;

import java.time.LocalDate;

public class ComandoUrgencia {

	private int idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private boolean esHospitalizacion;

	public ComandoUrgencia(int idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps) {

	}

	public boolean isEsHospitalizacion() {
		return esHospitalizacion;
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

}
