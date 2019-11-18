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
	void one_arg_constructor() {
		ComandoUrgencia command = new ComandoUrgencia(100L, null, LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		assertNull(command.getNombrePersona());
		assertNotNull(command.getIdPaciente());
	}

}
