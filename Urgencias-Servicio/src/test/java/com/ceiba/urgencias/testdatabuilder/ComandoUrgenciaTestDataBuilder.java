package com.ceiba.urgencias.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;

public class ComandoUrgenciaTestDataBuilder {
	private Long idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private LocalDate fechaHospitalizacion;
	private LocalDate fechaCirugia;

	public ComandoUrgenciaTestDataBuilder() {
		idPaciente = 100L;
		nombrePersona = "Jhon";
		fechaIngreso = LocalDate.now();
		eps = "SURA";
		fechaHospitalizacion = LocalDate.now();
		fechaCirugia = LocalDate.now();
	}

	public ComandoUrgencia build() {
		return new ComandoUrgencia(idPaciente, nombrePersona, fechaIngreso, eps, fechaHospitalizacion, fechaCirugia);
	}
}
