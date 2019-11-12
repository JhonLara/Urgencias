package com.ceiba.urgencias.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

@Service
public class ServicioConsultarUrgencias {
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioConsultarUrgencias(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public List<Urgencia> ejecutar() {
		return this.repositorioUrgencia.obtenerUrgencias();
	}
}
