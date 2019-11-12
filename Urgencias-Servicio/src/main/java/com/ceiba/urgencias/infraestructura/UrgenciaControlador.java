package com.ceiba.urgencias.infraestructura;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorConsultarUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorConsultarUrgencias;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorCrearUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorEliminarUrgencia;
import com.ceiba.urgencias.dominio.modelo.Urgencia;

@RestController
@RequestMapping(value = "/urgencias")
public class UrgenciaControlador {

	private final ManejadorCrearUrgencia manejadorCrearUrgencia;
	private final ManejadorEliminarUrgencia manejadorEliminarUrgencia;
	private final ManejadorConsultarUrgencias manejadorConsultarUrgencias;
	private final ManejadorConsultarUrgencia manejadorConsultarUrgencia;

	public UrgenciaControlador(ManejadorConsultarUrgencias manejadorConsultarUrgencias,
			ManejadorEliminarUrgencia manejadorEliminarUrgencia, ManejadorCrearUrgencia manejadorCrearUrgencia,
			ManejadorConsultarUrgencia manejadorConsultarUrgencia) {
		this.manejadorCrearUrgencia = manejadorCrearUrgencia;
		this.manejadorEliminarUrgencia = manejadorEliminarUrgencia;
		this.manejadorConsultarUrgencias = manejadorConsultarUrgencias;
		this.manejadorConsultarUrgencia = manejadorConsultarUrgencia;

	}

	// Proxy Reverse Angular
	// ExceptionHandler
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/agregarUrgencia")
	public void agregarUrgencia(@RequestBody ComandoUrgencia comandoUrgencia) {
		this.manejadorCrearUrgencia.ejecutar(comandoUrgencia);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarUrgencia/{ID_PACIENTE}")
	public void eliminarLibro(@PathVariable(name = "ID_PACIENTE") Long idPaciente) {
		this.manejadorEliminarUrgencia.ejecutar(idPaciente);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerUrgencias")
	public List<Urgencia> obtenerLibrosDisponibles() {
		return manejadorConsultarUrgencias.ejecutar();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerUrgencia/{ID_PACIENTE}")
	public Urgencia buscarUrgencia(@PathVariable(name = "ID_PACIENTE") Long idPaciente) {
		return manejadorConsultarUrgencia.ejecutar(idPaciente);
	}
}
