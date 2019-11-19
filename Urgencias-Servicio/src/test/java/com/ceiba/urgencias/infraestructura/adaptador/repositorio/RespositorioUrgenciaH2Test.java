package com.ceiba.urgencias.infraestructura.adaptador.repositorio;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import com.ceiba.urgencias.infraestructura.UrgenciaRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;
import com.ceiba.urgencias.testdatabuilder.UrgenciaEntidadDataBuilder;

public class RespositorioUrgenciaH2Test {
	@Test
	void obtenerUrgencias() {
		UrgenciaEntidad urgenciaEntidad = new UrgenciaEntidadDataBuilder().build();
		List<UrgenciaEntidad> listaUrgenciasEntidad = new ArrayList<>();
		listaUrgenciasEntidad.add(urgenciaEntidad);

		UrgenciaRepositorioJPA urgenciaRepositorioJPA = mock(UrgenciaRepositorioJPA.class);
		ModelMapper modelMapper = mock(ModelMapper.class);
		RepositorioUrgenciaH2 repositorioUrgenciaH2 = new RepositorioUrgenciaH2(urgenciaRepositorioJPA);

		when(urgenciaRepositorioJPA.findAll()).thenReturn(listaUrgenciasEntidad);

		assertNotNull(repositorioUrgenciaH2.obtenerUrgencias());

	}

}
