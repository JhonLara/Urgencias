package com.ceiba.urgencias.infraestructura.controlador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorConsultarUrgencias;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorCrearUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorEliminarUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorFacturarUrgencia;
import com.ceiba.urgencias.testdatabuilder.ComandoUrgenciaTestDataBuilder;

public class UrgenciaControladorTest {

	private ManejadorCrearUrgencia manejadorCrearUrgencia = mock(ManejadorCrearUrgencia.class);
	private ManejadorConsultarUrgencias manejadorConsultarUrgencias = mock(ManejadorConsultarUrgencias.class);
	private ManejadorEliminarUrgencia manejadorEliminarUrgencia = mock(ManejadorEliminarUrgencia.class);
	private ManejadorFacturarUrgencia manejadorFacturarUrgencia = mock(ManejadorFacturarUrgencia.class);

	@Test
	void agregarUrgencia() {
		ComandoUrgencia urgencia = new ComandoUrgenciaTestDataBuilder().build();

		UrgenciaControlador controlador = new UrgenciaControlador(manejadorConsultarUrgencias,
				manejadorEliminarUrgencia, manejadorCrearUrgencia, manejadorFacturarUrgencia);

		assertDoesNotThrow(() -> controlador.agregarUrgencia(urgencia));
	}

	@Test
	void eliminarUrgencia() {
		Long idPaciente = 1L;
		UrgenciaControlador controlador = new UrgenciaControlador(manejadorConsultarUrgencias,
				manejadorEliminarUrgencia, manejadorCrearUrgencia, manejadorFacturarUrgencia);
		assertDoesNotThrow(() -> controlador.eliminarUrgencia(idPaciente));

	}

	@Test
	void obtenerUrgencias() {
		UrgenciaControlador controlador = new UrgenciaControlador(manejadorConsultarUrgencias,
				manejadorEliminarUrgencia, manejadorCrearUrgencia, manejadorFacturarUrgencia);
		assertDoesNotThrow(() -> controlador.obtenerUrgencias());

	}

	@Test
	void facturarUrgencia() {
		UrgenciaControlador controlador = new UrgenciaControlador(manejadorConsultarUrgencias,
				manejadorEliminarUrgencia, manejadorCrearUrgencia, manejadorFacturarUrgencia);
		assertDoesNotThrow(() -> controlador.facturarUrgencia(1L));

	}
}