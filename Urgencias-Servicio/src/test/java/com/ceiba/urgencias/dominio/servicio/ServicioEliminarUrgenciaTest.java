package com.ceiba.urgencias.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioEliminarUrgenciaTest {

	@Test
	void eliminarUrgenciaNoExistente() {
		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		ServicioEliminarUrgencia servicio = new ServicioEliminarUrgencia(repositorioUrgencia);

		assertDoesNotThrow(() -> servicio.ejecutar(1L));
	}

}
