package com.ceiba.urgencias.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarUrgencias;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioEliminarUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioFacturarUrgencia;

@Configuration
public class BeanServicio {
	@Bean
	public ServicioFacturarUrgencia crearServicioFacturaUrgencias(RepositorioUrgencia repositorioUrgencia) {
		return new ServicioFacturarUrgencia(repositorioUrgencia);
	}

	@Bean
	public ServicioCrearUrgencia crearServicioCrearUrgencia(RepositorioUrgencia repositorioUrgencia) {
		return new ServicioCrearUrgencia(repositorioUrgencia);
	}

	@Bean
	public ServicioConsultarUrgencias crearServicioConsultarUrgencias(RepositorioUrgencia repositorioUrgencia) {
		return new ServicioConsultarUrgencias(repositorioUrgencia);
	}

	@Bean
	public ServicioEliminarUrgencia crearServicioEliminarUrgencia(RepositorioUrgencia repositorioUrgencia) {
		return new ServicioEliminarUrgencia(repositorioUrgencia);
	}
}
