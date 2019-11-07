package com.ceiba.urgencias.dominio;

import java.util.List;

import com.ceiba.urgencias.infraestructura.Urgencia;

public interface UrgenciaServicio {

	public void agregarUrgencia(Urgencia urgencia);

	public void eliminarUrgencia(Long id);

	public Urgencia buscarUrgenciaIdPaciente(Long id);

	public List<Urgencia> obtenerUrgencias();

}
