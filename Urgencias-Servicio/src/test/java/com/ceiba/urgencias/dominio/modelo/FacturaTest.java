package com.ceiba.urgencias.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class FacturaTest {

	@Test
	void instanciaCorrecta() {
		Factura factura = new Factura(123L, 10L, 20L, 50000L, 60000L, 7000L, 80000L);

		assertNotNull(factura);
	}

	@Test
	void gettersAndSetters() {

		Long numeroDias = 12L;
		Long numeHospitalizacion = 13L;
		Long valorDiario = 30000L;
		Long valorDiarioHosp = 50000L;
		Long valorCirugia = 2000000L;
		Long valorTotalDiario = 360000L;
		Long valorTotalHospitalizacion = 650000L;
		Long valorTotal = 3000000L;
		Long valorDiarioFestivo = 40000L;
		Long valorDiarioHospFestivo = 60000L;

		Factura factura = new Factura(numeroDias, numeHospitalizacion, valorDiario, valorDiarioHosp, valorCirugia,
				valorDiario, valorTotalHospitalizacion);

		factura.setNumeroDias(numeroDias);
		factura.setNumeroDiasHospitalizacion(numeHospitalizacion);
		factura.setValorCirugia(valorCirugia);
		factura.setValorDiario(valorDiario);
		factura.setValorDiarioHospitalizacion(valorDiarioHosp);
		factura.setValorTotalDiasSinHospitalizacion(valorTotalDiario);
		factura.setValorTotalHospitalizacion(valorTotalHospitalizacion);
		factura.setValorTotal(valorTotal);
		factura.setValorDiarioFestivo(valorDiarioFestivo);
		factura.setValorDiarioHospitalizacionFestivo(valorDiarioHospFestivo);

		assertEquals(numeroDias, factura.getNumeroDias());
		assertEquals(numeHospitalizacion, factura.getNumeroDiasHospitalizacion());
		assertEquals(valorDiario, factura.getValorDiario());
		assertEquals(valorDiarioHosp, factura.getValorDiarioHospitalizacion());
		assertEquals(valorCirugia, factura.getValorCirugia());
		assertEquals(valorTotalDiario, factura.getValorTotalDiasSinHospitalizacion());
		assertEquals(valorTotalHospitalizacion, factura.getValorTotalHospitalizacion());
		assertEquals(valorTotal, factura.getValorTotal());
		assertEquals(valorDiarioFestivo, factura.getValorDiarioFestivo());
		assertEquals(valorDiarioHospFestivo, factura.getValorDiarioHospitalizacionFestivo());

	}
}
