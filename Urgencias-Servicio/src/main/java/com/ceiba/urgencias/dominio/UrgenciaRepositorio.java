package com.ceiba.urgencias.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.urgencias.infraestructura.Urgencia;

@Repository
public interface UrgenciaRepositorio extends JpaRepository<Urgencia, Long> {

}
