package com.ceiba.urgencias.aplicacion.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarUrgencia;

@Component
public class ManejadorConsultarUrgencia {
	private final ServicioConsultarUrgencia servicioConsultarUrgencia;

	public ManejadorConsultarUrgencia(ServicioConsultarUrgencia servicioConsultarUrgencia) {

		this.servicioConsultarUrgencia = servicioConsultarUrgencia;
	}

	public Urgencia ejecutar(Long idPaciente) {
		return this.servicioConsultarUrgencia.ejecutar(idPaciente);
	}
}
