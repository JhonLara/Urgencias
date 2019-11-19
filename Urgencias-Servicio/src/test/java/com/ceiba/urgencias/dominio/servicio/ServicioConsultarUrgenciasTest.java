package com.ceiba.urgencias.dominio.servicio;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.testdatabuilder.ComandoUrgenciaTestDataBuilder;

public class ServicioConsultarUrgenciasTest {

	@Test
	void obtenerUrgencias() {
		RepositorioUrgencia repositorioUrgencia = mock(RepositorioUrgencia.class);
		ComandoUrgencia urgenciaCreada = new ComandoUrgenciaTestDataBuilder().build();
		List<ComandoUrgencia> listaUrgencias = new ArrayList<ComandoUrgencia>();
		listaUrgencias.add(urgenciaCreada);
		Mockito.when(repositorioUrgencia.obtenerUrgencias()).thenReturn(listaUrgencias);
		ServicioConsultarUrgencias service = new ServicioConsultarUrgencias(repositorioUrgencia);

		List<ComandoUrgencia> results = service.ejecutar();

		assertFalse(results.isEmpty());
	}

}