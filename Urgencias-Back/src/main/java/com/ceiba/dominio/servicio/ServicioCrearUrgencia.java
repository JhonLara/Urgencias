package com.ceiba.dominio.servicio;

import org.springframework.stereotype.Service;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.modelo.Urgencia;
import com.ceiba.dominio.puerto.repositorio.RepositorioUrgencia;

@Service
public class ServicioCrearUrgencia {

	private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya se encuenta registrado en el sistema";
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioCrearUrgencia(RepositorioUrgencia repositorioUrgencia) {
		this.repositorioUrgencia = repositorioUrgencia;
	}

	private void validarExistencia(Urgencia urgencia) {
		boolean existe = this.repositorioUrgencia.existe(urgencia);
		if (existe) {
			throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	public void ejecutar(Urgencia urgencia) {
		validarExistencia(urgencia);
		this.repositorioUrgencia.guardar(urgencia);
	}
}
