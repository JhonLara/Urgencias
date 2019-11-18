package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.fabrica.FabricaUrgencia;
import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearUrgencia;

public class ManejadorCrearUrgenciaTest {
	@Test
	void execute() {
		// arrange

		ComandoUrgencia command = new ComandoUrgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		Urgencia urgencia = new Urgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now());
		ServicioCrearUrgencia service = mock(ServicioCrearUrgencia.class);
		FabricaUrgencia fabricaUrgencia = new FabricaUrgencia();
		ManejadorCrearUrgencia handler = new ManejadorCrearUrgencia(service, fabricaUrgencia);

		// act - assert
		assertDoesNotThrow(() -> handler.ejecutar(command));
	}
}
