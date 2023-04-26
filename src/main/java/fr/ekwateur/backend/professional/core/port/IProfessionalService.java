package fr.ekwateur.backend.professional.core.port;

import fr.ekwateur.backend.professional.core.adapter.model.ProfessionalDto;
import fr.ekwateur.backend.professional.core.domain.Professional;

import java.util.List;

public interface IProfessionalService {
    ProfessionalDto create(ProfessionalDto professionalDto);
    List<ProfessionalDto> findAll();
    ProfessionalDto findById(Long id);
    ProfessionalDto update(ProfessionalDto professionalDto);
    void deleteById(Long id);
}
