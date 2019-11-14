package com.ceiba.urgencias.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.urgencias.dominio.modelo.Urgencia;

public interface RepositorioUrgencia {
	void guardar(Urgencia urgencia);

	void eliminar(Long idPaciente);

	List<Urgencia> obtenerUrgencias();

	Urgencia facturarrUrgencia(Long idPaciente);
}
