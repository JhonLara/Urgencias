package com.ceiba.urgencias.infraestructura.controlador;

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
import com.ceiba.urgencias.aplicacion.manejador.ManejadorConsultarUrgencias;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorCrearUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorEliminarUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorFacturarUrgencia;
import com.ceiba.urgencias.dominio.modelo.Factura;

@RestController
@RequestMapping(value = "/urgencias")
public class UrgenciaControlador {

	private final ManejadorCrearUrgencia manejadorCrearUrgencia;
	private final ManejadorEliminarUrgencia manejadorEliminarUrgencia;
	private final ManejadorConsultarUrgencias manejadorConsultarUrgencias;
	private final ManejadorFacturarUrgencia manejadorFacturarUrgencia;

	public UrgenciaControlador(ManejadorConsultarUrgencias manejadorConsultarUrgencias,
			ManejadorEliminarUrgencia manejadorEliminarUrgencia, ManejadorCrearUrgencia manejadorCrearUrgencia,
			ManejadorFacturarUrgencia manejadorFacturarUrgencia) {
		this.manejadorCrearUrgencia = manejadorCrearUrgencia;
		this.manejadorEliminarUrgencia = manejadorEliminarUrgencia;
		this.manejadorConsultarUrgencias = manejadorConsultarUrgencias;
		this.manejadorFacturarUrgencia = manejadorFacturarUrgencia;

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
	public void eliminarUrgencia(@PathVariable(name = "ID_PACIENTE") Long idPaciente) {
		this.manejadorEliminarUrgencia.ejecutar(idPaciente);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerUrgencias")
	public List<ComandoUrgencia> obtenerUrgencias() {
		return manejadorConsultarUrgencias.ejecutar();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/facturarUrgencia/{ID_PACIENTE}")
	public Factura facturarUrgencia(@PathVariable(name = "ID_PACIENTE") Long idPaciente) {
		return manejadorFacturarUrgencia.ejecutar(idPaciente);
	}
}
