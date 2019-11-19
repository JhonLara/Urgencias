package com.ceiba.urgencias.infraestructura.entidad;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class UrgenciaEntidadTest {
	@Test
	void getter_setter() {

		Long numeroDocumento = 123L;
		String nombre = "Jhon";
		String eps = "SURA";
		LocalDate fechaHoy = LocalDate.now();
		UrgenciaEntidad urgencia = new UrgenciaEntidad(100L, "Jhon", fechaHoy, eps, fechaHoy, fechaHoy);

		urgencia.setEps(eps);
		urgencia.setFechaCirugia(fechaHoy);
		urgencia.setFechaHospitalizacion(fechaHoy);
		urgencia.setFechaIngreso(fechaHoy);
		urgencia.setIdPaciente(numeroDocumento);
		urgencia.setNombrePersona(nombre);

		// assert
		assertEquals(nombre, urgencia.getNombrePersona());
		assertEquals(eps, urgencia.getEps());
		assertEquals(numeroDocumento, urgencia.getIdPaciente());
		assertEquals(fechaHoy, urgencia.getFechaCirugia());
		assertEquals(fechaHoy, urgencia.getFechaHospitalizacion());
		assertEquals(fechaHoy, urgencia.getFechaIngreso());
	}
}
