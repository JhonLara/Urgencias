package com.ceiba.urgencias.infraestructura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.urgencias.dominio.UrgenciaServicio;

@RestController
public class UrgenciaControlador {
	@Autowired
	private UrgenciaServicio urgenciaServicio;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/agregarUrgencia")
	public void agregarPersona(Urgencia urgencia) {
		urgenciaServicio.agregarUrgencia(urgencia);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarUrgencia/{ID}")
	public void eliminarPersona(@PathVariable(name = "ID") Long id) {
		urgenciaServicio.eliminarUrgencia(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerUrgencias")
	public List<Urgencia> obtenerPersonas() {
		return urgenciaServicio.obtenerUrgencias();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/buscarUrgencia/{ID}")
	public Urgencia buscarPersona(@PathVariable(name = "ID") Long id) {
		return urgenciaServicio.buscarUrgenciaIdPaciente(id);
	}

}
