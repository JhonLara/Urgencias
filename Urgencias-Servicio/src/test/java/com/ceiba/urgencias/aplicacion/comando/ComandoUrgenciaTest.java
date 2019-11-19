package com.ceiba.urgencias.aplicacion.comando;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ComandoUrgenciaTest {
	@Test
	void getters() {
		ComandoUrgencia command = new ComandoUrgencia();
		assertNull(command.getIdPaciente());
		assertNull(command.getEps());
		assertNull(command.getNombrePersona());
		assertNull(command.getFechaCirugia());
		assertNull(command.getFechaHospitalizacion());
		assertNull(command.getFechaIngreso());
	}

	@Test
	void setters() {
		ComandoUrgencia command = new ComandoUrgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		command.setEps(null);
		command.setFechaCirugia(null);
		command.setFechaHospitalizacion(null);
		command.setFechaIngreso(null);
		command.setIdPaciente(null);
		command.setNombrePersona(null);

		assertNull(command.getFechaIngreso());
		assertNull(command.getIdPaciente());

	}

	@Test
	void one_arg_constructor() {
		ComandoUrgencia command = new ComandoUrgencia(100L, null, LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		assertNull(command.getNombrePersona());
		assertNotNull(command.getIdPaciente());
	}

}
