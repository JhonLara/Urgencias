package com.ceiba.urgencias.aplicacion.manejador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarUrgencias;

@Component
public class ManejadorConsultarUrgencias {
	private final ServicioConsultarUrgencias servicioConsultarUrgencias;

	public ManejadorConsultarUrgencias(ServicioConsultarUrgencias servicioConsultarUrgencias) {

		this.servicioConsultarUrgencias = servicioConsultarUrgencias;
	}

	@Transactional
	public List<ComandoUrgencia> ejecutar() {
		return this.servicioConsultarUrgencias.ejecutar();
	}
}
