package fr.ekwateur.backend.particular.core.port;

import fr.ekwateur.backend.particular.core.domain.Particular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParticularRepository extends JpaRepository<Particular, Long> {
}
