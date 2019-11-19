package com.ceiba.urgencias.infraestructura.entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "URGENCIA")
public class UrgenciaEntidad {

	@Id
	@Column(name = "ID_PACIENTE")
	private Long idPaciente;

	@Column(name = "NOMBRE_PERSONA")
	private String nombrePersona;

	@Column(name = "FECHA_INGRESO")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaIngreso;

	@Column(name = "EPS")
	private String eps;

	@Column(name = "FECHA_HOSPITALIZACION")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaHospitalizacion;

	@Column(name = "FECHA_CIRUGIA")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaCirugia;

	public UrgenciaEntidad(Long idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps,
			LocalDate fechaHospitalizacion, LocalDate fechaCirugia) {
		super();
		this.idPaciente = idPaciente;
		this.nombrePersona = nombrePersona;
		this.fechaIngreso = fechaIngreso;
		this.eps = eps;
		this.fechaHospitalizacion = fechaHospitalizacion;
		this.fechaCirugia = fechaCirugia;
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

	public LocalDate getFechaHospitalizacion() {
		return fechaHospitalizacion;
	}

	public void setFechaHospitalizacion(LocalDate fechaHospitalizacion) {
		this.fechaHospitalizacion = fechaHospitalizacion;
	}

	public LocalDate getFechaCirugia() {
		return fechaCirugia;
	}

	public void setFechaCirugia(LocalDate fechaCirugia) {
		this.fechaCirugia = fechaCirugia;
	}

	public UrgenciaEntidad() {
	}

}
