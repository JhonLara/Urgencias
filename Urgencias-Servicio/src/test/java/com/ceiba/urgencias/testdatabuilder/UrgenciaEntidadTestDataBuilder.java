package com.ceiba.urgencias.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;

public class UrgenciaEntidadTestDataBuilder {
	private Long idPaciente;
	private String nombrePersona;
	private LocalDate fechaIngreso;
	private String eps;
	private LocalDate fechaHospitalizacion;
	private LocalDate fechaCirugia;

	public UrgenciaEntidadTestDataBuilder() {
		idPaciente = 100L;
		nombrePersona = "Jhon";
		fechaIngreso = LocalDate.now();
		eps = "SURA";
		fechaHospitalizacion = LocalDate.now();
		fechaCirugia = LocalDate.now();
	}

	public UrgenciaEntidad build() {
		return new UrgenciaEntidad(idPaciente, nombrePersona, fechaIngreso, eps, fechaHospitalizacion, fechaCirugia);
	}
}
