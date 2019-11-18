package com.ceiba.urgencias.dominio.modelo;

import java.time.LocalDate;

import com.ceiba.urgencias.dominio.validador.ValidadorArgumento;

public class Urgencia {

	private static final String LA_ID_PACIENTE_ES_UN_DATO_OBLIGATORIO = "La identificacion del paciente es un dato obligatorio.";
	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre del afiliado es un dato obligatorio.";
	private static final String LA_FECHA_DE_INGRESO_ES_UN_DATO_OBLIGATORIO = "La fecha de ingreso del paciente es un dato obligatorio.";
	private static final String LA_FECHA_DEBE_SER_MENOR_IGUAL = "La fecha debe de ser menor o igual a la fecha del sistema.";

	public static final Long VALOR_DIA_URGENCIA = 50000L;
	public static final Long VALOR_DIA_URGENCIA_FESTIVO = 60000L;
	public static final Long VALOR_DIA_HOSPITALIZACION = 80000L;
	public static final Long VALOR_DIA_HOSPITALIZACION_FESTIVO = 90000L;
	public static final Long VALOR_CIRUGIA = 9000000L;

	private Long idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private LocalDate fechaHospitalizacion;
	private LocalDate fechaCirugia;

	public Urgencia(Long idPaciente, String nombrePersona, LocalDate fechaIngreso, String eps,
			LocalDate fechaHospitalizacion, LocalDate fechaCirugia) {

		ValidadorArgumento.validarObligatorio(idPaciente, LA_ID_PACIENTE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(nombrePersona, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(fechaIngreso, LA_FECHA_DE_INGRESO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarFecha(fechaIngreso, LA_FECHA_DEBE_SER_MENOR_IGUAL);

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

}
