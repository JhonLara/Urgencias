package com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoUrgencia;
import com.ceiba.aplicacion.fabrica.FabricaUrgencia;
import com.ceiba.dominio.modelo.Urgencia;
import com.ceiba.dominio.servicio.ServicioCrearUrgencia;

@Component
public class ManejadorCrearUsuario {

	private final ServicioCrearUrgencia servicioCrearUrgencia;
	private final FabricaUrgencia fabricaUsuario;

	public ManejadorCrearUsuario(ServicioCrearUrgencia servicioCrearUrgencia, FabricaUrgencia fabricaUsuario) {
		this.servicioCrearUrgencia = servicioCrearUrgencia;
		this.fabricaUsuario = fabricaUsuario;
	}
	public void ejecutar(ComandoUrgencia comandoUrgencia) {
		Urgencia usuario = this.fabricaUsuario.crear(comandoUrgencia);
		this.servicioCrearUrgencia.ejecutar(usuario);
	}
}
