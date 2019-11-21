package com.ceiba.urgencias.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.fabrica.FabricaUrgencia;
import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearUrgencia;

@Component
public class ManejadorCrearUrgencia {
	private final ServicioCrearUrgencia servicioCrearUrgencia;
	private final FabricaUrgencia fabricaUrgencia;

	public ManejadorCrearUrgencia(ServicioCrearUrgencia servicioCrearUrgencia, FabricaUrgencia fabricaUrgencia) {

		this.servicioCrearUrgencia = servicioCrearUrgencia;
		this.fabricaUrgencia = fabricaUrgencia;
	}
	@Transactional
	public void ejecutar(ComandoUrgencia comandoUrgencia) {
		Urgencia urgencia = this.fabricaUrgencia.crearUrgencia(comandoUrgencia);
		this.servicioCrearUrgencia.ejecutar(urgencia);
	}
}
