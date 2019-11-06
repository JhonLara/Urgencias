package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Urgencia;

public interface RepositorioUgencia {

	/**
	 * Permite crear las urgencias
	 * 
	 * @param urgencia
	 */
	void crear(Urgencia urgencia);

	/**
	 * Permite determinar si previamente se registro la urgencia con el paciente
	 * digitado
	 * 
	 * @param urgencia
	 * @return si existe o no
	 */
	boolean existe(Urgencia urgencia);

}
