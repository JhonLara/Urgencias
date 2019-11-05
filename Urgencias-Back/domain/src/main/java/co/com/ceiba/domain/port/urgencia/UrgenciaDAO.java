package co.com.ceiba.domain.port.urgencia;

import java.util.List;

import co.com.ceiba.domain.dto.urgencia.UrgenciaDTO;

public interface UrgenciaDAO {
	public UrgenciaDTO findByIdentification(int identification);

	public List<UrgenciaDTO> getAll();
}
