package com.ceiba.urgencias.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.infraestructura.UrgenciaRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;

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
	public List<ComandoUrgencia> obtenerUrgencias() {
		List<UrgenciaEntidad> listaUrgenciasEntidad = urgenciaRepositorioJPA.findAll();
		List<ComandoUrgencia> listaUrgencias = new ArrayList<>();
		for (UrgenciaEntidad urgenciaEntidad : listaUrgenciasEntidad) {
			ComandoUrgencia urgencia = modelMapper.map(urgenciaEntidad, ComandoUrgencia.class);
			listaUrgencias.add(urgencia);
		}
		return listaUrgencias;
	}

	@Override
	public ComandoUrgencia obtenerUrgencia(Long idPaciente) {
		Optional<UrgenciaEntidad> urgenciaEntidad = urgenciaRepositorioJPA.findById(idPaciente);
		return urgenciaEntidad.isPresent() ? modelMapper.map(urgenciaEntidad.get(), ComandoUrgencia.class) : null;
	}

}
