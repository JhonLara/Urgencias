package com.ceiba.urgencias.infraestructura.adaptador.repositorio;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.infraestructura.UrgenciaRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;
import com.ceiba.urgencias.testdatabuilder.UrgenciaEntidadTestDataBuilder;
import com.ceiba.urgencias.testdatabuilder.UrgenciaTestDataBuilder;

@RunWith(SpringRunner.class)
@AutoConfigureTestEntityManager
@Transactional
@SpringBootTest
public class RespositorioUrgenciaH2Test {

	@Autowired
	RepositorioUrgenciaH2 repositorioUrgenciaH2;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void obtenerUrgencias() {

		UrgenciaEntidad urgenciaEntidad = new UrgenciaEntidadTestDataBuilder().build();
		List<UrgenciaEntidad> listaUrgenciasEntidad = new ArrayList<>();
		listaUrgenciasEntidad.add(urgenciaEntidad);

		UrgenciaRepositorioJPA urgenciaRepositorioJPA = mock(UrgenciaRepositorioJPA.class);
		RepositorioUrgenciaH2 repositorioUrgenciaH2 = new RepositorioUrgenciaH2(urgenciaRepositorioJPA);

		when(urgenciaRepositorioJPA.findAll()).thenReturn(listaUrgenciasEntidad);

		assertNotNull(repositorioUrgenciaH2.obtenerUrgencias());

	}

	@Test
	void agregarUrgencia() {

		Urgencia urgencia = new UrgenciaTestDataBuilder().build();

		repositorioUrgenciaH2.guardar(urgencia);
		UrgenciaEntidad urgenciaEntidad = entityManager.find(UrgenciaEntidad.class, urgencia.getIdPaciente());
		assertEquals(urgencia.getNombrePersona(), urgenciaEntidad.getNombrePersona());
	}

	@Test
	void eliminarUrgencia() {

		Urgencia urgencia = new UrgenciaTestDataBuilder().build();

		repositorioUrgenciaH2.guardar(urgencia);

		repositorioUrgenciaH2.eliminar(urgencia.getIdPaciente());
		UrgenciaEntidad urgenciaEntidad = entityManager.find(UrgenciaEntidad.class, urgencia.getIdPaciente());
		assertNull(urgenciaEntidad);
	}

}
