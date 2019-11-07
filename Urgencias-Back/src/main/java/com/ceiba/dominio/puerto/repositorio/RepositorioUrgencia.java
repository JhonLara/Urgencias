package com.ceiba.dominio.puerto.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.dominio.modelo.Urgencia;

@Repository
public interface RepositorioUrgencia {

	void guardar(Urgencia urgencia);

	boolean existe(Urgencia urgencia);
}