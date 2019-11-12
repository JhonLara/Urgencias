package com.ceiba.urgencias.infraestructura.adaptador.repositorio;

import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.infraestructura.UrgenciaRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUrgenciaH2 implements RepositorioUrgencia {

	private final UrgenciaRepositorioJPA urgenciaRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioUrgenciaH2(UrgenciaRepositorioJPA urgenciaRepositorioJPA) {
		this.urgenciaRepositorioJPA = urgenciaRepositorioJPA;
	}

	@Override
	public void guardar(Urgencia urgencia) {
		UrgenciaEntidad urgenciaEntidad = modelMapper.map(urgencia, UrgenciaEntidad.class);
		urgenciaRepositorioJPA.save(urgenciaEntidad);
	}

	@Override
	public void eliminar(Long idPaciente) {
		urgenciaRepositorioJPA.deleteById(idPaciente);
	}

	@Override
	public List<Urgencia> obtenerUrgencias() {
		List<UrgenciaEntidad> listaUrgenciasEntidad = urgenciaRepositorioJPA.findAll();
		List<Urgencia> listaUrgencias = new ArrayList<>();
		for (UrgenciaEntidad urgenciaEntidad : listaUrgenciasEntidad) {
			Urgencia urgencia = modelMapper.map(urgenciaEntidad, Urgencia.class);
			listaUrgencias.add(urgencia);
		}
		return listaUrgencias;
	}

	@Override
	public Urgencia obtenerUrgencia(Long idPaciente) {
		Optional<UrgenciaEntidad> urgenciaEntidad = urgenciaRepositorioJPA.findById(idPaciente);
		return urgenciaEntidad.isPresent() ? modelMapper.map(urgenciaEntidad.get(), Urgencia.class) : null;
	}

}
