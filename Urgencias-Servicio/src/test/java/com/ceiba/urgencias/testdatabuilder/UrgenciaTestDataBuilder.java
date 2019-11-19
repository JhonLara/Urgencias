package com.ceiba.urgencias.testdatabuilder;

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
		idPaciente = 100L;
		nombrePersona = "Jhon";
		fechaIngreso = LocalDate.now();
		eps = "SURA";
		fechaHospitalizacion = LocalDate.now();
		fechaCirugia = LocalDate.now();
	}

	public Urgencia build() {
		return new Urgencia(idPaciente, nombrePersona, fechaIngreso, eps, fechaHospitalizacion, fechaCirugia);
	}
}
