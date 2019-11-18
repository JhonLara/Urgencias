package com.ceiba.urgencias.dominio.servicio;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioConsultarUrgenciasTest {

	@Test
	void obtenerUrgencias() {
		RepositorioUrgencia repositorioUrgencia = mock(RepositorioUrgencia.class);
		Urgencia urgenciaCreada = new Urgencia(100L, "Carlos", LocalDate.now(), "SURA", LocalDate.now(),
				LocalDate.now());
		List<Urgencia> listaUrgencias = new ArrayList<Urgencia>();
		listaUrgencias.add(urgenciaCreada);
		Mockito.when(repositorioUrgencia.obtenerUrgencias()).thenReturn(listaUrgencias);
		ServicioConsultarUrgencias service = new ServicioConsultarUrgencias(repositorioUrgencia);

		List<Urgencia> results = service.ejecutar();

		assertFalse(results.isEmpty());
	}

}