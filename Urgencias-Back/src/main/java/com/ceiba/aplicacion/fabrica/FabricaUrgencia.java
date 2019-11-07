package com.ceiba.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.aplicacion.comando.ComandoUrgencia;
import com.ceiba.dominio.modelo.Urgencia;

@Component
public class FabricaUrgencia {

	public Urgencia crear(ComandoUrgencia comandoUrgencia) {
		return new Urgencia(comandoUrgencia.getIdPaciente(), comandoUrgencia.getNombrePersona(),
				comandoUrgencia.getFechaIngreso(), comandoUrgencia.getEps());
	}
}
