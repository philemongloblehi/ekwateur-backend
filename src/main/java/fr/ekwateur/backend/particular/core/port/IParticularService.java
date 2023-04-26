package fr.ekwateur.backend.particular.core.port;

import fr.ekwateur.backend.particular.core.adapter.model.ParticularDto;

import java.util.List;

public interface IParticularService {
    ParticularDto create(ParticularDto particularDto);
    List<ParticularDto> findAll();
    ParticularDto findById(Long id);
    ParticularDto update(ParticularDto particularDto);
    void deleteById(Long id);
}
