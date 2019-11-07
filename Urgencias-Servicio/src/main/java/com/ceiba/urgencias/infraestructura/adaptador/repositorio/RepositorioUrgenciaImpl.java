package com.ceiba.urgencias.infraestructura.adaptador.repositorio;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.infraestructura.UrgenciaRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUrgenciaImpl implements RepositorioUrgencia {

	private final UrgenciaRepositorioJPA urgenciaRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioUrgenciaImpl(UrgenciaRepositorioJPA urgenciaRepositorioJPA) {
		this.urgenciaRepositorioJPA = urgenciaRepositorioJPA;
	}

	@Override
	public void guardar(Urgencia urgencia) {
		UrgenciaEntidad urgenciaEntidad = modelMapper.map(urgencia, UrgenciaEntidad.class);
		urgenciaRepositorioJPA.save(urgenciaEntidad);
	}

}
