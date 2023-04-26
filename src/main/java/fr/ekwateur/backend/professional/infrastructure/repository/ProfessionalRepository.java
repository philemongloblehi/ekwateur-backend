package fr.ekwateur.backend.professional.infrastructure.repository;

import fr.ekwateur.backend.professional.core.domain.Professional;
import fr.ekwateur.backend.professional.core.port.IProfessionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProfessionalRepository {
    private final IProfessionalRepository repository;

    public Professional create(Professional Professional) {
        return repository.save(Professional);
    }

    public List<Professional> findAll() {
        return repository.findAll();
    }

    public Professional findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Professional update(Professional Professional) {
        return repository.save(Professional);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
