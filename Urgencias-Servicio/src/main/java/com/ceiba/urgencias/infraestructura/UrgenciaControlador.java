package com.ceiba.urgencias.infraestructura;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.aplicacion.manejador.ManejadorCrearUrgencia;

@RestController
@RequestMapping(value = "/urgencias")
public class UrgenciaControlador {

	private final ManejadorCrearUrgencia manejadorCrearUrgencia;

	public UrgenciaControlador(ManejadorCrearUrgencia manejadorCrearUrgencia) {
		this.manejadorCrearUrgencia = manejadorCrearUrgencia;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/agregarUrgencia")
	public void agregarPersona(@RequestBody ComandoUrgencia comandoUrgencia) {
		this.manejadorCrearUrgencia.ejecutar(comandoUrgencia);
	}

}
