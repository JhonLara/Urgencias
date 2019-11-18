package com.ceiba.urgencias.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.ceiba.urgencias.aplicacion.comando.ComandoUrgencia;
import com.ceiba.urgencias.dominio.modelo.Factura;
import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;

//@Service
public class ServicioFacturarUrgencia {
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioFacturarUrgencia(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public Factura ejecutar(Long idPaciente) {

		ComandoUrgencia urgencia = this.repositorioUrgencia.obtenerUrgencia(idPaciente);
		Long[] numeroDias = urgencia.getFechaHospitalizacion() != null
				? obtenerDias(urgencia.getFechaIngreso(), urgencia.getFechaHospitalizacion())
				: obtenerDias(urgencia.getFechaIngreso(), LocalDate.now());

		Long[] numeroDiasHospitalizacion = urgencia.getFechaHospitalizacion() != null
				? obtenerDias(urgencia.getFechaHospitalizacion(), LocalDate.now())
				: new Long[] { 0L, 0L };

		Factura factura = new Factura((numeroDias[0] + numeroDias[1]),
				numeroDiasHospitalizacion[0] + numeroDiasHospitalizacion[1], Urgencia.VALOR_DIA_URGENCIA,
				Urgencia.VALOR_DIA_HOSPITALIZACION, urgencia.getFechaCirugia() != null ? Urgencia.VALOR_CIRUGIA : 0L,
				(numeroDias[0] * Urgencia.VALOR_DIA_URGENCIA) + (numeroDias[1] * Urgencia.VALOR_DIA_URGENCIA_FESTIVO),
				(numeroDiasHospitalizacion[0] * Urgencia.VALOR_DIA_HOSPITALIZACION)
						+ (numeroDiasHospitalizacion[1] * Urgencia.VALOR_DIA_HOSPITALIZACION_FESTIVO));

		factura.setValorTotal(factura.getValorTotalDiasSinHospitalizacion() + factura.getValorTotalHospitalizacion()
				+ factura.getValorCirugia());

		factura.setValorDiarioFestivo(Urgencia.VALOR_DIA_URGENCIA_FESTIVO);
		factura.setValorDiarioHospitalizacionFestivo(Urgencia.VALOR_DIA_HOSPITALIZACION_FESTIVO);

		return factura;
	}

	private Long[] obtenerDias(LocalDate fecha, LocalDate fechaFinal) {
		Long[] dias = new Long[2];
		Long numeroDiasUrgencia = ChronoUnit.DAYS.between(fecha, fechaFinal);
		Long diasHabiles = 0L;
		Long diasNoHabiles = 0L;
		while (numeroDiasUrgencia > 0) {
			fecha = fecha.plusDays(1);
			if (fecha.getDayOfWeek() != DayOfWeek.SUNDAY && fecha.getDayOfWeek() != DayOfWeek.SATURDAY) {
				diasHabiles++;
				numeroDiasUrgencia--;
			} else {
				diasNoHabiles++;
				numeroDiasUrgencia--;
			}
		}
		dias[0] = diasHabiles;
		dias[1] = diasNoHabiles;
		return dias;
	}
}
