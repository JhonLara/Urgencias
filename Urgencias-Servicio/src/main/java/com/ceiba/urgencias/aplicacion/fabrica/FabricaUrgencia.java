package com.ceiba.urgencias.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.modelo.Urgencia;

@Component
public class FabricaUrgencia {

	public Urgencia crearUrgencia(ComandoUrgencia comandoUrgencia) {
		return new Urgencia(comandoUrgencia.getIdPaciente(), comandoUrgencia.getNombrePersona(),
				comandoUrgencia.getFechaIngreso(), comandoUrgencia.getEps(), comandoUrgencia.getFechaHospitalizacion(),
				comandoUrgencia.getFechaCirugia());
	}
}
