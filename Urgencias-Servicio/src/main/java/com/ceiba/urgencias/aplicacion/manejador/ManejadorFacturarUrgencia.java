package com.ceiba.urgencias.aplicacion.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.dominio.modelo.Factura;
import com.ceiba.urgencias.dominio.servicio.ServicioFacturarUrgencia;

@Component
public class ManejadorFacturarUrgencia {
	private final ServicioFacturarUrgencia servicioFacturarUrgencia;

	public ManejadorFacturarUrgencia(ServicioFacturarUrgencia servicioFacturarUrgencia) {

		this.servicioFacturarUrgencia = servicioFacturarUrgencia;
	}

	public Factura ejecutar(Long idPaciente) {
		return this.servicioFacturarUrgencia.ejecutar(idPaciente);
	}
}
