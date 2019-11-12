package com.ceiba.urgencias.aplicacion.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarUrgencias;

@Component
public class ManejadorConsultarUrgencias {
	private final ServicioConsultarUrgencias servicioConsultarUrgencias;

	public ManejadorConsultarUrgencias(ServicioConsultarUrgencias servicioConsultarUrgencias) {

		this.servicioConsultarUrgencias = servicioConsultarUrgencias;
	}

	public List<Urgencia> ejecutar() {
		return this.servicioConsultarUrgencias.ejecutar();
	}
}
