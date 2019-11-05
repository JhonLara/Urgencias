package co.com.ceiba.domain.service.command.urgencia;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.ceiba.domain.dto.urgencia.UrgenciaDTO;
import co.com.ceiba.domain.port.urgencia.UrgenciaDAO;
import co.com.ceiba.domain.port.urgencia.UrgenciaRepository;

public class SaveUrgenciaService {
	private final Logger LOGGER = Logger.getLogger("SaveUrgenciaService");
	UrgenciaRepository urgenciaRepository;
	UrgenciaDAO urgenciaDao;

	public SaveUrgenciaService(UrgenciaRepository urgenciaRepository, UrgenciaDAO urgenciaDao) {
		this.urgenciaRepository = urgenciaRepository;
		this.urgenciaDao = urgenciaDao;
	}

	public UrgenciaDTO execute(UrgenciaDTO urgenciaDTO) {
		UrgenciaDTO response = null;
		try {
			UrgenciaDTO existentPerson = urgenciaDao.findByIdentification(urgenciaDTO.getIdPersona());
			if (null != existentPerson) {
				response = createErrorObject("La persona se encuentra en urgencias");
			}
		} catch (NoSuchElementException e) {
			response = urgenciaRepository.save(urgenciaDTO);
			LOGGER.log(Level.INFO, "El usuario no esta en urgencias y se ingresa", e);
		}
		return response;
	}

	public UrgenciaDTO createErrorObject(String message) {
		return new UrgenciaDTO();
	}
}
