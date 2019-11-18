package com.ceiba.urgencias.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import com.ceiba.urgencias.dominio.servicio.ServicioFacturarUrgencia;

@Configuration
public class BeanServicio {
	@Bean
	public ServicioFacturarUrgencia crearServicioFacturaurgencias(RepositorioUrgencia repositorioUrgencia) {
		return new ServicioFacturarUrgencia(repositorioUrgencia);
	}
}
