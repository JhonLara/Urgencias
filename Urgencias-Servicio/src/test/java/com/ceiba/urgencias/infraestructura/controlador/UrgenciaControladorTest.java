package com.ceiba.urgencias.infraestructura.controlador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorConsultarUrgencias;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorCrearUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorEliminarUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorFacturarUrgencia;

public class UrgenciaControladorTest {

	private ManejadorCrearUrgencia manejadorCrearUrgencia = mock(ManejadorCrearUrgencia.class);
	private ManejadorConsultarUrgencias manejadorConsultarUrgencias = mock(ManejadorConsultarUrgencias.class);
	private ManejadorEliminarUrgencia manejadorEliminarUrgencia = mock(ManejadorEliminarUrgencia.class);
	private ManejadorFacturarUrgencia manejadorFacturarUrgencia = mock(ManejadorFacturarUrgencia.class);

	@Test
	void agregarUrgencia() {
		ComandoUrgencia urgencia = new ComandoUrgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		
		UrgenciaControlador service = new UrgenciaControlador(manejadorConsultarUrgencias, manejadorEliminarUrgencia,
				manejadorCrearUrgencia, manejadorFacturarUrgencia);

		assertDoesNotThrow(() -> service.agregarUrgencia(urgencia));
	}

	@Test
	void eliminarUrgencia() {
		Long idPaciente = 1L;
		UrgenciaControlador service = new UrgenciaControlador(manejadorConsultarUrgencias, manejadorEliminarUrgencia,
				manejadorCrearUrgencia, manejadorFacturarUrgencia);
		assertDoesNotThrow(() -> service.eliminarUrgencia(idPaciente));

	}
}
