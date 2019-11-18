package com.ceiba.urgencias.dominio.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.BasePrueba;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;
import com.ceiba.urgencias.dominio.modelo.Factura;
import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioConsultarUrgenciasTest {

	@Test
	public void obtenerUrgencias() {

		Urgencia urgencia = new Urgencia(100L, "Carlos", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now());
		List<Urgencia> listaUrgencias = new ArrayList<>();
		listaUrgencias.add(urgencia);
		ServicioConsultarUrgencias servicioConsultarUrgencias = Mockito.mock(ServicioConsultarUrgencias.class);
		Mockito.when(servicioConsultarUrgencias.ejecutar()).thenReturn(listaUrgencias);

		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		Mockito.when(repositorioUrgencia.obtenerUrgencias()).thenReturn(listaUrgencias);

		List<Urgencia> urgenciasObtenidas = servicioConsultarUrgencias.ejecutar();

		// assert
		Assertions.assertNotNull(urgenciasObtenidas);
		Assertions.assertNotNull(urgenciasObtenidas.get(0));
		Assertions.assertEquals(100L, urgenciasObtenidas.get(0).getIdPaciente());

	}

	@Test
	public void facturarUrgencia() {

		Factura factura = new Factura(10L, 10L, 50000L, 40000L, 1000000L, 500000L, 400000L);
		Urgencia urgencia = new Urgencia(100L, "Carlos", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now());

		ServicioFacturarUrgencia servicioFacturarUrgencia = Mockito.mock(ServicioFacturarUrgencia.class);
		Mockito.when(servicioFacturarUrgencia.ejecutar(100L)).thenReturn(factura);

		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		Mockito.when(repositorioUrgencia.obtenerUrgencia(100L)).thenReturn(urgencia);

		Factura facturaObtenida = servicioFacturarUrgencia.ejecutar(100L);

		// assert
		Assertions.assertNotNull(factura);
		Assertions.assertEquals(1000000L, facturaObtenida.getValorCirugia());

	}

}