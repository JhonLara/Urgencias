package com.ceiba.urgencias.dominio.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.urgencias.dominio.modelo.Urgencia;

public class UrgenciaTestDataBuilder {
	private Long idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private LocalDate fechaHospitalizacion;
	private LocalDate fechaCirugia;

	public UrgenciaTestDataBuilder() {
		this.idPaciente = 100L;
		this.nombrePersona = "Jhon";
		this.fechaIngreso = LocalDate.now();
		this.eps = "SURA";
		this.fechaHospitalizacion = LocalDate.now();
		this.fechaCirugia = LocalDate.now();
	}

	public Urgencia build() {
		return new Urgencia(idPaciente, nombrePersona, fechaIngreso, eps, fechaHospitalizacion, fechaCirugia);
	}
}
