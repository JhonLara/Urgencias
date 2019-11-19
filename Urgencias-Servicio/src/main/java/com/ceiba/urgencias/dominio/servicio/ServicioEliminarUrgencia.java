package com.ceiba.urgencias.dominio.servicio;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioEliminarUrgencia {
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioEliminarUrgencia(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public void ejecutar(Long idPaciente) {
		this.repositorioUrgencia.eliminar(idPaciente);
	}
}
