package com.ceiba.urgencias.dominio.modelo;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionFecha;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionMenorQueCero;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;

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
			throw new ExcepcionFecha(mensaje);
		}
	}

	public static void validarMenorQueCero(Long valor, String mensaje) {
		if (valor < 0) {
			throw new ExcepcionMenorQueCero(mensaje);
		}
	}
}
