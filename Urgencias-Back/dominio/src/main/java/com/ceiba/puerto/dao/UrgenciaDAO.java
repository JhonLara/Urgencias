package com.ceiba.puerto.dao;

import java.util.Collection;

import com.ceiba.modelo.dto.UrgenciaDTO;

public interface UrgenciaDAO {
	/**
	 * Permite listar las urgencias
	 * 
	 * @return
	 */
	Collection<UrgenciaDTO> listar();

}
