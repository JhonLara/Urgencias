package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoUrgencia;
import com.ceiba.modelo.entidad.Urgencia;

public class FabricaUrgencia {

	public Urgencia crear(ComandoUrgencia comandoUrgencia) {
		return new Urgencia(comandoUrgencia.getIdPaciente(), comandoUrgencia.getNombrePersona(),
				comandoUrgencia.getFechaIngreso(), comandoUrgencia.getEps());
	}
}
