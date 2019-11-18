package com.ceiba.urgencias.dominio.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioConsultarUrgenciasTest {

	@Test
	public void obtenerUrgencias() {

		Urgencia urgencia = new Urgencia(100L, "Carlos", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now());
		List<Urgencia> listaUrgencias = new ArrayList<>();
		listaUrgencias.add(urgencia);
		ServicioConsultarUrgencias servicioConsultarUrgencias = Mockito.mock(ServicioConsultarUrgencias.class);
		Mockito.when(servicioConsultarUrgencias.ejecutar()).thenReturn(listaUrgencias);

		RepositorioUrgencia repositorioUrgencia = Mockito.mock(RepositorioUrgencia.class);
		Mockito.when(repositorioUrgencia.obtenerUrgencias()).thenReturn(listaUrgencias);

		List<Urgencia> urgenciasObtenidas = servicioConsultarUrgencias.ejecutar();

		// assert
		Assertions.assertNotNull(urgenciasObtenidas);
		Assertions.assertNotNull(urgenciasObtenidas.get(0));
		Assertions.assertEquals(100L, urgenciasObtenidas.get(0).getIdPaciente());

	}

}