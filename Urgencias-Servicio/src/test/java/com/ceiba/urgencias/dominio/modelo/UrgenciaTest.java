package com.ceiba.urgencias.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionFecha;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionMenorQueCero;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;
import com.ceiba.urgencias.testdatabuilder.UrgenciaTestDataBuilder;

public class UrgenciaTest {
	@Test
	void instanciaIdPacienteNull() {
		assertThrows(ExcepcionObligatorio.class,
				() -> new Urgencia(null, "Jhon", LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now()));
	}

	@Test
	void instanciaIdNombreNull() {
		assertThrows(ExcepcionObligatorio.class,
				() -> new Urgencia(100L, null, LocalDate.now(), "SURA", LocalDate.now(), LocalDate.now()));
	}

	@Test
	void instanciaFechaIncorrecta() {
		assertThrows(ExcepcionFecha.class, () -> new Urgencia(100L, "Jhon", LocalDate.now().plusDays(1L), "SURA",
				LocalDate.now(), LocalDate.now()));
	}

	@Test
	void instanciaNumeroMenorFactura() {
		assertThrows(ExcepcionMenorQueCero.class,
				() -> new Factura(100L, -10L, 15000L, 20000L, 15000000L, 200000L, 56000L));
	}

	@Test
	void instanciaCorrecta() {
		Urgencia urgencia = new UrgenciaTestDataBuilder().build();

		assertNotNull(urgencia);
	}

	@Test
	void gettersAndSetters() {

		Long numeroDocumento = 123L;
		String nombre = "Jhon";
		String eps = "SURA";
		LocalDate fechaHoy = LocalDate.now();
		Urgencia urgencia = new UrgenciaTestDataBuilder().build();

		urgencia.setEps(eps);
		urgencia.setFechaCirugia(fechaHoy);
		urgencia.setFechaHospitalizacion(fechaHoy);
		urgencia.setFechaIngreso(fechaHoy);
		urgencia.setIdPaciente(numeroDocumento);
		urgencia.setNombrePersona(nombre);

		assertEquals(nombre, urgencia.getNombrePersona());
		assertEquals(eps, urgencia.getEps());
		assertEquals(numeroDocumento, urgencia.getIdPaciente());
		assertEquals(fechaHoy, urgencia.getFechaCirugia());
		assertEquals(fechaHoy, urgencia.getFechaHospitalizacion());
		assertEquals(fechaHoy, urgencia.getFechaIngreso());
	}
}
