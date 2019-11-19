package com.ceiba.urgencias.infraestructura.error;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;

public class ManejadorErrorTest {

	@Test
	void instanciaCorrecta() {
		ManejadorError manejadorError = new ManejadorError();
		assertNotNull(manejadorError);
	}

	@Test
	void handleAllExceptionCorrecta() {
		ManejadorError manejadorError = new ManejadorError();
		ExcepcionObligatorio excepcionObligatorio = new ExcepcionObligatorio("Este dato es obligatoro");
		assertTrue(manejadorError.handleAllException(excepcionObligatorio).hasBody());

	}

	@Test
	void handleAllExceptionNull() {
		ManejadorError manejadorError = new ManejadorError();
		assertTrue(manejadorError.handleAllException(new Exception()).hasBody());

	}
}
