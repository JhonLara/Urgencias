package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.fabrica.FabricaUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearUrgencia;
import com.ceiba.urgencias.testdatabuilder.ComandoUrgenciaTestDataBuilder;

public class ManejadorCrearUrgenciaTest {
	@Test
	void ejecutar() {
		ComandoUrgencia command = new ComandoUrgenciaTestDataBuilder().build();
		ServicioCrearUrgencia service = mock(ServicioCrearUrgencia.class);
		FabricaUrgencia fabricaUrgencia = new FabricaUrgencia();
		ManejadorCrearUrgencia handler = new ManejadorCrearUrgencia(service, fabricaUrgencia);

		assertDoesNotThrow(() -> handler.ejecutar(command));
	}
}
