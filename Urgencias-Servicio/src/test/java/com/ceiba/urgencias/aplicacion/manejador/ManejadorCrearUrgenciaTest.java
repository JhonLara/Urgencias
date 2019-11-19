package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.fabrica.FabricaUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearUrgencia;

public class ManejadorCrearUrgenciaTest {
	@Test
	void execute() {
		ComandoUrgencia command = new ComandoUrgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		ServicioCrearUrgencia service = mock(ServicioCrearUrgencia.class);
		FabricaUrgencia fabricaUrgencia = new FabricaUrgencia();
		ManejadorCrearUrgencia handler = new ManejadorCrearUrgencia(service, fabricaUrgencia);

		assertDoesNotThrow(() -> handler.ejecutar(command));
	}
}
