package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.modelo.Factura;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioFacturarUrgencia;
import com.ceiba.urgencias.testdatabuilder.ComandoUrgenciaTestDataBuilder;

public class ManejadorFacturarUrgenciaTest {
	@Test
	void ejecutar() {

		ComandoUrgencia command = new ComandoUrgenciaTestDataBuilder().build();
		Factura factura = new Factura(10L, 10L, 50000L, 40000L, 1000000L, 500000L, 400000L);
		RepositorioUrgencia repositorioUrgencia = mock(RepositorioUrgencia.class);
		ServicioFacturarUrgencia service = mock(ServicioFacturarUrgencia.class);
		doReturn(command).when(repositorioUrgencia).obtenerUrgencia(100L);
		doReturn(factura).when(service).ejecutar(100L);

		ManejadorFacturarUrgencia handler = new ManejadorFacturarUrgencia(service);

		assertNotNull(handler.ejecutar(100L));
	}
}
