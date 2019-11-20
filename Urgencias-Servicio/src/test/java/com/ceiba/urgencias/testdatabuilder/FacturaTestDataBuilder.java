package com.ceiba.urgencias.testdatabuilder;

import com.ceiba.urgencias.dominio.modelo.Factura;

public class FacturaTestDataBuilder {

	private Long numeroDias;
	private Long numeroDiasHospitalizacion;
	private Long valorDiario;
	private Long valorDiarioHospitalizacion;
	private Long valorCirugia;
	private Long valorTotalDiasSinHospitalizacion;
	private Long valorTotalHospitalizacion;

	public FacturaTestDataBuilder() {
		numeroDias = 10L;
		numeroDiasHospitalizacion = 5L;
		valorDiario = 40000L;
		valorDiarioHospitalizacion = 50000L;
		valorCirugia = 8000000L;
		valorTotalDiasSinHospitalizacion = 400000L;
		valorTotalHospitalizacion = 250000L;
	}

	public Factura build() {
		return new Factura(numeroDias, numeroDiasHospitalizacion, valorDiario, valorDiarioHospitalizacion, valorCirugia,
				valorTotalDiasSinHospitalizacion, valorTotalHospitalizacion);
	}

}
