package com.ceiba.dominio.validador;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}
}
