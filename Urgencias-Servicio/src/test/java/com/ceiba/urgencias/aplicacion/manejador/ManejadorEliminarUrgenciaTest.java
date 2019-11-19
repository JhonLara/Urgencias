package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.servicio.ServicioEliminarUrgencia;

public class ManejadorEliminarUrgenciaTest {
	@Test
	void ejecutar() {
		ServicioEliminarUrgencia service = mock(ServicioEliminarUrgencia.class);
		ManejadorEliminarUrgencia handler = new ManejadorEliminarUrgencia(service);

		assertDoesNotThrow(() -> handler.ejecutar(1L));
	}

}
