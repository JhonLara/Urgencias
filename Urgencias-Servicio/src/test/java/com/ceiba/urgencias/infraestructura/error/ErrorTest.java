package com.ceiba.urgencias.infraestructura.error;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class ErrorTest {
	@Test
	void constructor() {
		Error error = new Error("EjemploException", "Ejemplo de excepcion");
		assertNotNull(error);
	}

	@Test
	void gettersAndSetters() {
		Error error = new Error("EjemploException", "Ejemplo de excepcion");
		assertNotNull(error.getMensajeExcepcion());
		assertNotNull(error.getNombreExcepcion());

	}
}
