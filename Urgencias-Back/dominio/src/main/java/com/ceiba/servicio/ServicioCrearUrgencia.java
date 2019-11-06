package com.ceiba.servicio;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Urgencia;
import com.ceiba.puerto.repositorio.RepositorioUgencia;


public class ServicioCrearUrgencia {

	private static final String EL_PACIENTE_YA_ESTA_EN_URGENCIAS = "El paciente ya se encuentra en urgencias";
	
	private RepositorioUgencia repositorioUgencia;

	public ServicioCrearUrgencia(RepositorioUgencia repositorioUgencia) {
		this.repositorioUgencia = repositorioUgencia;
	}

	public void ejecutar(Urgencia urgencia) {
		validarExistenciaPrevia(urgencia);
		this.repositorioUgencia.crear(urgencia);
	}

	private void validarExistenciaPrevia(Urgencia urgencia) {
		boolean existe = this.repositorioUgencia.existe(urgencia);
		if (existe) {
			throw new ExcepcionDuplicidad(EL_PACIENTE_YA_ESTA_EN_URGENCIAS);
		}
	}

}
