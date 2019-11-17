package com.ceiba.urgencias.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.ceiba.urgencias.dominio.modelo.Factura;
import com.ceiba.urgencias.dominio.modelo.Urgencia;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioUrgencia;
import java.time.temporal.ChronoUnit;

@Service
public class ServicioFacturarUrgencia {
	private RepositorioUrgencia repositorioUrgencia;

	public ServicioFacturarUrgencia(RepositorioUrgencia repositorioUrgencia) {

		this.repositorioUrgencia = repositorioUrgencia;
	}

	public Factura ejecutar(Long idPaciente) {

		Urgencia urgencia = this.repositorioUrgencia.obtenerUrgencia(idPaciente);
		Long[] numeroDias = urgencia.getFechaHospitalizacion() != null
				? obtenerDias(urgencia.getFechaIngreso(), urgencia.getFechaHospitalizacion())
				: obtenerDias(urgencia.getFechaIngreso(), LocalDate.now());
		Long[] numeroDiasHospitalizacion = urgencia.getFechaHospitalizacion() != null
				? obtenerDias(urgencia.getFechaHospitalizacion(), LocalDate.now())
				: new Long[2];
		Factura factura = new Factura();

		factura.setNumeroDias(numeroDias[0] + numeroDias[1]);
		factura.setNumeroDiasHospitalizacion(numeroDiasHospitalizacion[0] + numeroDiasHospitalizacion[1]);

		factura.setValorDiario(Urgencia.VALOR_DIA_URGENCIA);
		factura.setValorDiarioHospitalizacion(Urgencia.VALOR_DIA_HOSPITALIZACION);
		factura.setValorDiarioFestivo(Urgencia.VALOR_DIA_URGENCIA_FESTIVO);
		factura.setValorDiarioHospitalizacionFestivo(Urgencia.VALOR_DIA_HOSPITALIZACION_FESTIVO);

		factura.setValorCirugia(Urgencia.VALOR_CIRUGIA);

		factura.setValorTotalHospitalizacion((factura.getValorDiarioHospitalizacion() * numeroDiasHospitalizacion[0])
				+ (factura.getValorDiarioHospitalizacionFestivo() * numeroDiasHospitalizacion[1]));

		factura.setValorTotalDiasSinHospitalizacion(
				(numeroDias[0] * factura.getValorDiario()) + (numeroDias[1] * factura.getValorDiarioFestivo()));
		factura.setValorTotal(factura.getValorTotalDiasSinHospitalizacion() + factura.getValorTotalHospitalizacion()
				+ factura.getValorCirugia());

		return factura;
	}

	public Long[] obtenerDias(LocalDate fecha, LocalDate fechaFinal) {
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
