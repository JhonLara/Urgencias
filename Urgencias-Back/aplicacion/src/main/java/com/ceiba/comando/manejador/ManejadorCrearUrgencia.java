package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.comando.fabrica.FabricaUrgencia;
import com.ceiba.comando.ComandoUrgencia;
import com.ceiba.modelo.entidad.Urgencia;
import com.ceiba.servicio.ServicioCrearUrgencia;

@Component
public class ManejadorCrearUrgencia {

	private final ServicioCrearUrgencia servicioCrearUrgencia;
	private final FabricaUrgencia fabricaUrgencia;

	public ManejadorCrearUrgencia(ServicioCrearUrgencia servicioCrearUrgencia, FabricaUrgencia fabricaUrgencia) {
		this.servicioCrearUrgencia = servicioCrearUrgencia;
		this.fabricaUrgencia = fabricaUrgencia;
	}

	public void ejecutar(ComandoUrgencia comandoUrgencia) {
		Urgencia urgencia = this.fabricaUrgencia.crear(comandoUrgencia);
		this.servicioCrearUrgencia.ejecutar(urgencia);
	}
}
