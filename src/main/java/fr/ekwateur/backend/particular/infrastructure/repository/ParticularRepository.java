package fr.ekwateur.backend.particular.infrastructure.repository;

import fr.ekwateur.backend.particular.core.domain.Particular;
import fr.ekwateur.backend.particular.core.port.IParticularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParticularRepository {
    private final IParticularRepository repository;

    public Particular create(Particular particular) {
        return repository.insert(particular);
    }

    public List<Particular> findAll() {
        return repository.findAll();
    }

    public Particular findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Particular update(Particular particular) {
        return repository.save(particular);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
