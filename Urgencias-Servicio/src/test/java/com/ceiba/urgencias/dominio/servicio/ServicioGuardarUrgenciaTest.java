package com.ceiba.urgencias.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioGuardarUrgenciaTest {
	@Test
	void crearUrgencia() {
		Urgencia urgencia = new Urgencia(100L, "Jhon", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now());
		RepositorioUrgencia repositorioUrgencia = mock(RepositorioUrgencia.class);
		ServicioCrearUrgencia service = new ServicioCrearUrgencia(repositorioUrgencia);

		assertDoesNotThrow(() -> service.ejecutar(urgencia));
	}

}
