package fr.ekwateur.backend.particular.core.adapter.mapper;

import fr.ekwateur.backend.particular.core.adapter.model.ParticularDto;
import fr.ekwateur.backend.particular.core.domain.Particular;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticularMapper {
    public ParticularDto entityToDto(Particular particular) {
        if (particular == null) {
            return null;
        }
        return new ParticularDto(
                particular.getId(),
                particular.getReference(),
                particular.getCivility(),
                particular.getLastname(),
                particular.getFirstname()
        );
    }

    public List<ParticularDto> entityListToDtoList(List<Particular> particulars) {
        if (particulars.isEmpty()) {
            return Collections.emptyList();
        }
        return particulars.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Particular dtoToEntity(ParticularDto particularDto) {
        if (particularDto == null) {
            return null;
        }
        return new Particular(
                particularDto.getId(),
                particularDto.getReference(),
                particularDto.getCivility(),
                particularDto.getLastname(),
                particularDto.getFirstname()
        );
    }

}
