package com.ceiba.urgencias.aplicacion.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.dominio.servicio.ServicioEliminarUrgencia;

@Component
public class ManejadorEliminarUrgencia {
	private final ServicioEliminarUrgencia servicioEliminarUrgencia;

	public ManejadorEliminarUrgencia(ServicioEliminarUrgencia servicioEliminarUrgencia) {

		this.servicioEliminarUrgencia = servicioEliminarUrgencia;
	}

	public void ejecutar(Long idPaciente) {
		this.servicioEliminarUrgencia.ejecutar(idPaciente);
	}
}
