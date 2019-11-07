package com.ceiba.urgencias.dominio;

import java.util.List;

import com.ceiba.urgencias.infraestructura.entidad.UrgenciaEntidad;

public interface UrgenciaServicio {

	public void agregarUrgencia(UrgenciaEntidad urgencia);

	public void eliminarUrgencia(Long id);

	public UrgenciaEntidad buscarUrgenciaIdPaciente(Long id);

	public List<UrgenciaEntidad> obtenerUrgencias();

}
