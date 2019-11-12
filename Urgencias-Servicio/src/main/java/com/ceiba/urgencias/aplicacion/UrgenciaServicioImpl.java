package com.ceiba.urgencias.aplicacion;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.urgencias.dominio.UrgenciaServicio;
import com.ceiba.urgencias.infraestructura.UrgenciaRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;

@Service
public class UrgenciaServicioImpl implements UrgenciaServicio {

	@Autowired
	private UrgenciaRepositorioJPA urgenciaRepositorioJPA;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void agregarUrgencia(UrgenciaEntidad urgencia) {

		try {
			Optional<UrgenciaEntidad> optUrgencia = urgenciaRepositorioJPA.findById(urgencia.getIdPaciente());
			UrgenciaEntidad urgenciaActualizar = optUrgencia.get();
			urgenciaRepositorioJPA.save(urgenciaActualizar);
		} catch (NoSuchElementException nse) {

			urgenciaRepositorioJPA.save(urgencia);
		}

	}

	@Override
	public void eliminarUrgencia(Long id) {
		urgenciaRepositorioJPA.deleteById(id);
	}

	@Override
	public UrgenciaEntidad buscarUrgenciaIdPaciente(Long id) {
		try {
			Optional<UrgenciaEntidad> optUrgencia = urgenciaRepositorioJPA.findById(id);
			return optUrgencia.get();
		} catch (NoSuchElementException nse) {
			return null;
		}

	}

	@Override
	public List<UrgenciaEntidad> obtenerUrgencias() {
		String consultaUrgencias = "SELECT p FROM Persona p ";
		return entityManager.createQuery(consultaUrgencias).getResultList();
	}

}
