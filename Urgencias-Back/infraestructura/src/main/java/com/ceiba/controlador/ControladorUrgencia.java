package com.ceiba.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoUrgencia;
import com.ceiba.comando.manejador.ManejadorCrearUrgencia;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/controlador-urgencia")
public class ControladorUrgencia {

	private final ManejadorCrearUrgencia manejadorCrearUrgencia;

	public ControladorUrgencia(ManejadorCrearUrgencia manejadorCrearUrgencia) {
		this.manejadorCrearUrgencia = manejadorCrearUrgencia;
	}

	@PostMapping(value = "/guardar-urgencia", produces = MediaType.APPLICATION_JSON_VALUE)
	public void guardarUsuario(@RequestBody ComandoUrgencia comandoUrgencia) {
		this.manejadorCrearUrgencia.ejecutar(comandoUrgencia);
	}
}
