package fr.ekwateur.backend.professional.core.service;

import fr.ekwateur.backend.common.external.CustomerReferenceGeneratorImpl;
import fr.ekwateur.backend.professional.core.adapter.mapper.ProfessionalMapper;
import fr.ekwateur.backend.professional.core.adapter.model.ProfessionalDto;
import fr.ekwateur.backend.professional.core.domain.Professional;
import fr.ekwateur.backend.professional.core.port.IProfessionalService;
import fr.ekwateur.backend.professional.infrastructure.repository.ProfessionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionalService implements IProfessionalService {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionalMapper mapper;
    private final CustomerReferenceGeneratorImpl referenceGenerator;

    @Override
    public ProfessionalDto create(ProfessionalDto professionalDto) {
        Professional professional = mapper.dtoToEntity(professionalDto);
        professional.setReference(referenceGenerator.GenerateCustomerReference());
        Professional savedProfessional = professionalRepository.create(professional);
        return mapper.entityToDto(savedProfessional);
    }

    @Override
    public List<ProfessionalDto> findAll() {
        List<Professional> professionals = professionalRepository.findAll();
        return mapper.entityListToDtoList(professionals);
    }

    @Override
    public ProfessionalDto findById(Long id) {
        Professional professional = professionalRepository.findById(id);
        return mapper.entityToDto(professional);
    }

    @Override
    public ProfessionalDto update(ProfessionalDto professionalDto) {
        Professional professional = mapper.dtoToEntity(professionalDto);
        Professional updatedProfessional = professionalRepository.create(professional);
        return mapper.entityToDto(updatedProfessional);
    }

    @Override
    public void deleteById(Long id) {
        Professional professional = professionalRepository.findById(id);
        professionalRepository.deleteById(id);
    }
}
