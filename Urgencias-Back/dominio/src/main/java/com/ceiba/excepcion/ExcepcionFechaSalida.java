package com.ceiba.excepcion;

public class ExcepcionFechaSalida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionFechaSalida(String message) {
		super(message);
	}
}
