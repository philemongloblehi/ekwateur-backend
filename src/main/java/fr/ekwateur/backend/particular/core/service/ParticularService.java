package fr.ekwateur.backend.particular.core.service;

import fr.ekwateur.backend.common.external.CustomerReferenceGeneratorImpl;
import fr.ekwateur.backend.particular.core.adapter.mapper.ParticularMapper;
import fr.ekwateur.backend.particular.core.adapter.model.ParticularDto;
import fr.ekwateur.backend.particular.core.domain.Particular;
import fr.ekwateur.backend.particular.core.port.IParticularService;
import fr.ekwateur.backend.particular.infrastructure.repository.ParticularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticularService implements IParticularService {

    private final ParticularRepository particularRepository;
    private final ParticularMapper mapper;
    private final CustomerReferenceGeneratorImpl referenceGenerator;

    @Override
    public ParticularDto create(ParticularDto particularDto) {
        Particular entity = mapper.dtoToEntity(particularDto);
        entity.setReference(referenceGenerator.GenerateCustomerReference());
        Particular savedPaticular = particularRepository.create(entity);
        return mapper.entityToDto(savedPaticular);
    }

    @Override
    public List<ParticularDto> findAll() {
        List<Particular> particulars = particularRepository.findAll();
        return mapper.entityListToDtoList(particulars);
    }

    @Override
    public ParticularDto findById(Long id) {
        Particular particular = particularRepository.findById(id);
        return mapper.entityToDto(particular);
    }

    @Override
    public ParticularDto update(ParticularDto particularDto) {
        Particular particular = mapper.dtoToEntity(particularDto);
        Particular updatedParticular = particularRepository.create(particular);
        return mapper.entityToDto(updatedParticular);
    }

    @Override
    public void deleteById(Long id) {
        Particular particular = particularRepository.findById(id);
        particularRepository.deleteById(id);
    }
}
