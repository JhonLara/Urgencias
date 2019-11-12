package com.ceiba.urgencias;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearUrgencia;
import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;

@RunWith(SpringRunner.class)
@AutoConfigureTestEntityManager
@Transactional
@SpringBootTest
class UrgenciasApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	private final ServicioCrearUrgencia servicioCrearUrgencia;

	public UrgenciasApplicationTests(ServicioCrearUrgencia servicioCrearUrgencia) {
		this.servicioCrearUrgencia = servicioCrearUrgencia;
	}

	@Test
	public void guardarUrgencia() {
		Urgencia urgencia = new Urgencia();
		urgencia.setIdPaciente(1094942293L);
		urgencia.setEps("SURA");
		urgencia.setEsHospitalizacion(Boolean.TRUE);
		urgencia.setFechaIngreso(LocalDate.now());
		urgencia.setNombrePersona("Jhon Lara");
		this.servicioCrearUrgencia.ejecutar(urgencia);
		UrgenciaEntidad urgenciaFind = entityManager.find(UrgenciaEntidad.class, 1094942293L);

		assertEquals(urgencia.getNombrePersona(), urgenciaFind.getNombrePersona());
	}

}
