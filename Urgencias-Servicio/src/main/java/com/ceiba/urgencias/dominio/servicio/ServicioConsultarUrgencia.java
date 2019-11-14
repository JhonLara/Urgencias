package com.ceiba.urgencias.dominio.servicio;

import org.springframework.stereotype.Service;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

@Service
public class ServicioConsultarUrgencia {
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioConsultarUrgencia(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public Urgencia ejecutar(Long idPaciente) {
		return this.repositorioUrgencia.facturarrUrgencia(idPaciente);
	}
}
