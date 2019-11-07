package com.ceiba.urgencias.aplicacion;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.urgencias.dominio.UrgenciaRepositorio;
import com.ceiba.urgencias.dominio.UrgenciaServicio;
import com.ceiba.urgencias.infraestructura.Urgencia;

@Service
public class UrgenciaServicioImpl implements UrgenciaServicio {

	@Autowired
	private UrgenciaRepositorio urgenciaRepositorio;
	@PersistenceContext
	private EntityManager entityManager;

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String PALIDROMO = "los libros pal?ndromos solo se pueden utilizar en la biblioteca";
	public static final String PRESTADO = "No hay libros disponibles para prestar";
	public static final String NO_EXISTE = "El libro no existe";

	@Override
	public void agregarUrgencia(Urgencia urgencia) {
		urgencia.setFechaIngreso(LocalDate.now());

		try {
			Optional<Urgencia> optUrgencia = urgenciaRepositorio.findById(urgencia.getIdPaciente());
			Urgencia urgenciaActualizar = optUrgencia.get();
			urgenciaRepositorio.save(urgenciaActualizar);
		} catch (NoSuchElementException nse) {

			urgenciaRepositorio.save(urgencia);
		}

	}

	@Override
	public void eliminarUrgencia(Long id) {
		urgenciaRepositorio.deleteById(id);
	}

	@Override
	public Urgencia buscarUrgenciaIdPaciente(Long id) {
		try {
			Optional<Urgencia> optUrgencia = urgenciaRepositorio.findById(id);
			return optUrgencia.get();
		} catch (NoSuchElementException nse) {
			return null;
		}

	}

	@Override
	public List<Urgencia> obtenerUrgencias() {
		String consultaUrgencias = "SELECT p FROM Persona p ";
		return entityManager.createQuery(consultaUrgencias).getResultList();
	}

}
