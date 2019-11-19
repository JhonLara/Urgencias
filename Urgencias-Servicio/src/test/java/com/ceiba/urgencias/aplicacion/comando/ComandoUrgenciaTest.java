package com.ceiba.urgencias.aplicacion.comando;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.testdatabuilder.ComandoUrgenciaTestDataBuilder;

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
		ComandoUrgencia command = new ComandoUrgenciaTestDataBuilder().build();
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
	void constructor() {
		ComandoUrgencia command = new ComandoUrgenciaTestDataBuilder().build();
		assertNull(command.getNombrePersona());
		assertNotNull(command.getIdPaciente());
	}

}
