package fr.ekwateur.backend.professional.core.adapter.mapper;

import fr.ekwateur.backend.particular.core.adapter.model.ParticularDto;
import fr.ekwateur.backend.particular.core.domain.Particular;
import fr.ekwateur.backend.professional.core.adapter.model.ProfessionalDto;
import fr.ekwateur.backend.professional.core.domain.Professional;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessionalMapper {

    public ProfessionalDto entityToDto(Professional professional) {
        if (professional == null) {
            return null;
        }
        return new ProfessionalDto(
                professional.getId(),
                professional.getReference(),
                professional.getSiretNumber(),
                professional.getSocialReason(),
                professional.getTurnover()
        );
    }

    public List<ProfessionalDto> entityListToDtoList(List<Professional> professionals) {
        if (professionals == null) {
            Collections.emptyList();
        }
        return professionals.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Professional dtoToEntity(ProfessionalDto professionalDto) {
        if (professionalDto == null) {
            return null;
        }
        return new Professional(
                professionalDto.getId(),
                professionalDto.getReference(),
                professionalDto.getSiretNumber(),
                professionalDto.getSocialReason(),
                professionalDto.getTurnover()
        );
    }
}
