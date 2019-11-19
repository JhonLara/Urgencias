package com.ceiba.urgencias.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.testdatabuilder.UrgenciaTestDataBuilder;

public class ServicioGuardarUrgenciaTest {
	@Test
	void crearUrgencia() {
		Urgencia urgencia = new UrgenciaTestDataBuilder().build();
		RepositorioUrgencia repositorioUrgencia = mock(RepositorioUrgencia.class);
		ServicioCrearUrgencia service = new ServicioCrearUrgencia(repositorioUrgencia);

		assertDoesNotThrow(() -> service.ejecutar(urgencia));
	}

}
