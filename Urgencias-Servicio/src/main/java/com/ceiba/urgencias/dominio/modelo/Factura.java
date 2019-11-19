package com.ceiba.urgencias.dominio.modelo;

import com.ceiba.urgencias.dominio.validador.ValidadorArgumento;

public class Factura {

	private static final String EL_NUMERO_DEBE_SER_MAYOR_A_CERO = "El numero debe de ser mayor a cero.";

	private Long numeroDias;
	private Long numeroDiasHospitalizacion;
	private Long valorDiario;
	private Long valorDiarioHospitalizacion;
	private Long valorDiarioFestivo;
	private Long valorDiarioHospitalizacionFestivo;
	private Long valorCirugia;
	private Long valorTotalDiasSinHospitalizacion;
	private Long valorTotalHospitalizacion;
	private Long valorTotal;

	public Factura() {
	}

	public Factura(Long numeroDias, Long numeroDiasHospitalizacion, Long valorDiario, Long valorDiarioHospitalizacion,
			Long valorCirugia, Long valorTotalDiasSinHospitalizacion, Long valorTotalHospitalizacion) {

		ValidadorArgumento.validarMenorQueCero(numeroDias, EL_NUMERO_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarMenorQueCero(numeroDiasHospitalizacion, EL_NUMERO_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarMenorQueCero(valorDiario, EL_NUMERO_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarMenorQueCero(valorDiarioHospitalizacion, EL_NUMERO_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarMenorQueCero(valorCirugia, EL_NUMERO_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarMenorQueCero(valorTotalDiasSinHospitalizacion, EL_NUMERO_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarMenorQueCero(valorTotalHospitalizacion, EL_NUMERO_DEBE_SER_MAYOR_A_CERO);

		this.numeroDias = numeroDias;
		this.numeroDiasHospitalizacion = numeroDiasHospitalizacion;
		this.valorDiario = valorDiario;
		this.valorDiarioHospitalizacion = valorDiarioHospitalizacion;
		this.valorCirugia = valorCirugia;
		this.valorTotalDiasSinHospitalizacion = valorTotalDiasSinHospitalizacion;
		this.valorTotalHospitalizacion = valorTotalHospitalizacion;
	}

	public Long getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Long numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Long getNumeroDiasHospitalizacion() {
		return numeroDiasHospitalizacion;
	}

	public void setNumeroDiasHospitalizacion(Long numeroDiasHospitalizacion) {
		this.numeroDiasHospitalizacion = numeroDiasHospitalizacion;
	}

	public Long getValorDiario() {
		return valorDiario;
	}

	public void setValorDiario(Long valorDiario) {
		this.valorDiario = valorDiario;
	}

	public Long getValorDiarioHospitalizacion() {
		return valorDiarioHospitalizacion;
	}

	public void setValorDiarioHospitalizacion(Long valorDiarioHospitalizacion) {
		this.valorDiarioHospitalizacion = valorDiarioHospitalizacion;
	}

	public Long getValorTotalDiasSinHospitalizacion() {
		return valorTotalDiasSinHospitalizacion;
	}

	public void setValorTotalDiasSinHospitalizacion(Long valorTotalDiasSinHospitalizacion) {
		this.valorTotalDiasSinHospitalizacion = valorTotalDiasSinHospitalizacion;
	}

	public Long getValorTotalHospitalizacion() {
		return valorTotalHospitalizacion;
	}

	public void setValorTotalHospitalizacion(Long valorTotalHospitalizacion) {
		this.valorTotalHospitalizacion = valorTotalHospitalizacion;
	}

	public Long getValorCirugia() {
		return valorCirugia;
	}

	public void setValorCirugia(Long valorCirugia) {
		this.valorCirugia = valorCirugia;
	}

	public Long getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getValorDiarioFestivo() {
		return valorDiarioFestivo;
	}

	public void setValorDiarioFestivo(Long valorDiarioFestivo) {
		this.valorDiarioFestivo = valorDiarioFestivo;
	}

	public Long getValorDiarioHospitalizacionFestivo() {
		return valorDiarioHospitalizacionFestivo;
	}

	public void setValorDiarioHospitalizacionFestivo(Long valorDiarioHospitalizacionFestivo) {
		this.valorDiarioHospitalizacionFestivo = valorDiarioHospitalizacionFestivo;
	}

}
