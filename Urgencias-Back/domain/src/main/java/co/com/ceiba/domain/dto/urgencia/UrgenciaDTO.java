package co.com.ceiba.domain.dto.urgencia;

import java.time.LocalDate;

public class UrgenciaDTO {

	private int idPersona;
	private String nombrePersona;
	private LocalDate ingreso;
	private LocalDate salida;
	private boolean hospitalizacion;
	private String eps;
	private int edad;

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public LocalDate getIngreso() {
		return ingreso;
	}

	public void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}

	public LocalDate getSalida() {
		return salida;
	}

	public void setSalida(LocalDate salida) {
		this.salida = salida;
	}

	public boolean isHospitalizacion() {
		return hospitalizacion;
	}

	public void setHospitalizacion(boolean hospitalizacion) {
		this.hospitalizacion = hospitalizacion;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public UrgenciaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

}
