package com.ceiba.urgencias.dominio.servicio;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.modelo.Factura;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.testdatabuilder.ComandoUrgenciaTestDataBuilder;

public class ServicioFacturarUrgenciaTest {

	@Test
	public void facturarUrgencia() {

		ComandoUrgencia urgencia = new ComandoUrgenciaTestDataBuilder().build();

		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		ServicioFacturarUrgencia servicioFacturarUrgencia = new ServicioFacturarUrgencia(repositorioUrgencia);

		Mockito.when(repositorioUrgencia.obtenerUrgencia(100L)).thenReturn(urgencia);

		Factura facturaObtenida = servicioFacturarUrgencia.ejecutar(100L);

		// assert
		Assertions.assertNotNull(facturaObtenida);
		Assertions.assertNotNull(facturaObtenida.getValorCirugia());

	}

	@Test
	public void facturarUrgenciaSinCirugia() {

		ComandoUrgencia urgencia = new ComandoUrgenciaTestDataBuilder().build();
		urgencia.setFechaCirugia(null);

		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		ServicioFacturarUrgencia servicioFacturarUrgencia = new ServicioFacturarUrgencia(repositorioUrgencia);

		Mockito.when(repositorioUrgencia.obtenerUrgencia(100L)).thenReturn(urgencia);

		Factura facturaObtenida = servicioFacturarUrgencia.ejecutar(100L);

		// assert
		Assertions.assertNotNull(facturaObtenida);
		Assertions.assertEquals(0L, facturaObtenida.getValorCirugia());

	}

	@Test
	public void facturarUrgenciaSinHospitalizacion() {

		ComandoUrgencia urgencia = new ComandoUrgenciaTestDataBuilder().build();
		urgencia.setFechaHospitalizacion(null);

		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		ServicioFacturarUrgencia servicioFacturarUrgencia = new ServicioFacturarUrgencia(repositorioUrgencia);

		Mockito.when(repositorioUrgencia.obtenerUrgencia(100L)).thenReturn(urgencia);

		Factura facturaObtenida = servicioFacturarUrgencia.ejecutar(100L);

		// assert
		Assertions.assertNotNull(facturaObtenida);
		Assertions.assertEquals(0L, facturaObtenida.getValorTotalHospitalizacion());

	}

	@Test
	public void facturarUrgenciaConFestivos() {

		ComandoUrgencia urgencia = new ComandoUrgenciaTestDataBuilder().build();
		urgencia.setFechaIngreso(LocalDate.of(2019, 11, 1));
		urgencia.setFechaHospitalizacion(LocalDate.of(2019, 11, 7));

		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		ServicioFacturarUrgencia servicioFacturarUrgencia = new ServicioFacturarUrgencia(repositorioUrgencia);

		Mockito.when(repositorioUrgencia.obtenerUrgencia(100L)).thenReturn(urgencia);

		Factura facturaObtenida = servicioFacturarUrgencia.ejecutar(100L);

		// assert
		Assertions.assertNotNull(facturaObtenida);
		Assertions.assertNotNull(facturaObtenida.getValorCirugia());
		Assertions.assertTrue(facturaObtenida.getValorTotalHospitalizacion() > 0L);
	}

}