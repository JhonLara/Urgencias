package com.ceiba.urgencias.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;

public class UrgenciaTest {
	@Test
	void instanciaIdPacienteNull() {
		assertThrows(ExcepcionObligatorio.class,
				() -> new Urgencia(null, "Jhon", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now()));
	}

	@Test
	void instanciaIdNombreNull() {
		assertThrows(ExcepcionObligatorio.class,
				() -> new Urgencia(100L, null, LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now()));
	}

	@Test
	void instanciaCorrecta() {
		Urgencia urgencia = new Urgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now());

		assertNotNull(urgencia);
	}

	@Test
	void getter_setter() {

		Long numeroDocumento = 123L;
		String nombre = "Jhon";
		String eps = "SURA";
		LocalDate fechaHoy = LocalDate.now();
		Urgencia urgencia = new Urgencia(100L, "Jhon", fechaHoy, eps, fechaHoy, fechaHoy);

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
