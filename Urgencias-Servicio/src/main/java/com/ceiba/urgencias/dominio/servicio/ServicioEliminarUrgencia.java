package com.ceiba.urgencias.dominio.servicio;

import org.springframework.stereotype.Service;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

@Service
public class ServicioEliminarUrgencia {
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioEliminarUrgencia(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public void ejecutar(Long idPaciente) {
		this.repositorioUrgencia.eliminar(idPaciente);
	}
}
