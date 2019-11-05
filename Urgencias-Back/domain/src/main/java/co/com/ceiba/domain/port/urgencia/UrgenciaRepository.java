package co.com.ceiba.domain.port.urgencia;

import co.com.ceiba.domain.dto.urgencia.UrgenciaDTO;

public interface UrgenciaRepository {
	public UrgenciaDTO save(UrgenciaDTO urgencia);

	public void delete(int identification);

	public UrgenciaDTO update(UrgenciaDTO urgencia);
}
