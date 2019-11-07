package com.ceiba.urgencias.dominio.validador;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;

public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarCampoObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionObligatorio(mensaje);
		}
	}
}
