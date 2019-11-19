package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarUrgencias;

public class ManejadorConsultarUrgenciasTest {
	@Test
	void execute() {

		ComandoUrgencia command = new ComandoUrgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		List<ComandoUrgencia> listaUrgencias = new ArrayList<>();
		listaUrgencias.add(command);
		ServicioConsultarUrgencias service = mock(ServicioConsultarUrgencias.class);
		doReturn(listaUrgencias).when(service).ejecutar();
		ManejadorConsultarUrgencias handler = new ManejadorConsultarUrgencias(service);

		// act - assert
		assertFalse(handler.ejecutar().isEmpty());
	}
}
