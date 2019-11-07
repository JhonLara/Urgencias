package com.ceiba.dominio.modelo;

import java.time.LocalDate;

import com.ceiba.dominio.validador.ValidadorArgumento;

public class Urgencia {

	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre del paciente es un dato obligatorio.";
	private static final String LA_ID_PACIENTE_ES_UN_DATO_OBLIGATORIO = "La identificación del paciente es un dato obligatorio.";

	private int idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private boolean esHospitalizacion;

	public Urgencia(int idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps) {
		ValidadorArgumento.validarObligatorio(idPaciente, LA_ID_PACIENTE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(nombrePersona, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);

		this.nombrePersona = nombrePersona;
		this.eps = eps;
		this.fechaIngreso = fechaIngreso;
		this.idPaciente = idPaciente;
	}

	public boolean isEsHospitalizacion() {
		return esHospitalizacion;
	}

	public void setEsHospitalizacion(boolean esHospitalizacion) {
		this.esHospitalizacion = esHospitalizacion;
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
