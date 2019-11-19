package com.ceiba.urgencias.dominio.servicio;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

public class ServicioCrearUrgencia {

	private RepositorioUrgencia repositorioUrgencia;

	public ServicioCrearUrgencia(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public void ejecutar(Urgencia urgencia) {
		this.repositorioUrgencia.guardar(urgencia);
	}
}
