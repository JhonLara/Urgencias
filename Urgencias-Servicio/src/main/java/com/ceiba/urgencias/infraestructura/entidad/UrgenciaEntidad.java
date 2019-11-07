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

	@Column(name = "EPS_HOSPITALIZACION")
	private boolean esHospitalizacion;

	public UrgenciaEntidad() {
	}

	public UrgenciaEntidad(Long idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps,
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
