package com.ceiba.urgencias.dominio.servicio;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.modelo.Factura;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioFacturarUrgenciaTest {

	@Test
	public void facturarUrgencia() {

		ComandoUrgencia urgencia = new ComandoUrgencia(100L, "Carlos", LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());

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

		ComandoUrgencia urgencia = new ComandoUrgencia(100L, "Carlos", LocalDate.now(), "SURA", LocalDate.now(), null);

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

		ComandoUrgencia urgencia = new ComandoUrgencia(100L, "Carlos", LocalDate.now(), "SURA", null, LocalDate.now());

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

		ComandoUrgencia urgencia = new ComandoUrgencia(100L, "Carlos", LocalDate.of(2019, 11, 1), "SURA",
				LocalDate.of(2019, 11, 7), LocalDate.now());

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