package com.ceiba.urgencias.dominio.servicio;

import java.util.List;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioConsultarUrgencias {
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioConsultarUrgencias(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public List<ComandoUrgencia> ejecutar() {
		return this.repositorioUrgencia.obtenerUrgencias();
	}
}
