package com.ceiba.urgencias.aplicacion.comando;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPaciente")
public class ComandoUrgencia {

	private Long idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private LocalDate fechaHospitalizacion;
	private LocalDate fechaCirugia;

	public ComandoUrgencia() {
		super();
	}

	public ComandoUrgencia(Long idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps,
			LocalDate fechaHospitalizacion, LocalDate fechaCirugia) {
		this.idPaciente = idPaciente;
		this.nombrePersona = nombrePersona;
		this.fechaIngreso = fechaIngreso;
		this.eps = eps;
		this.fechaHospitalizacion = fechaHospitalizacion;
		this.fechaCirugia = fechaCirugia;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public void setFechaHospitalizacion(LocalDate fechaHospitalizacion) {
		this.fechaHospitalizacion = fechaHospitalizacion;
	}

	public void setFechaCirugia(LocalDate fechaCirugia) {
		this.fechaCirugia = fechaCirugia;
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

	public LocalDate getFechaHospitalizacion() {
		return fechaHospitalizacion;
	}

	public LocalDate getFechaCirugia() {
		return fechaCirugia;
	}

}
