package com.ceiba.urgencias.dominio.modelo;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;
import com.ceiba.urgencias.dominio.excepcion.ExceptionFecha;

public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionObligatorio(mensaje);
		}
	}

	public static void validarFecha(String valor, int longitud, String mensaje) {
		if (valor.length() < longitud) {
			throw new ExceptionFecha(mensaje);
		}
	}
}
