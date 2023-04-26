package fr.ekwateur.backend.professional.core.port;

import fr.ekwateur.backend.professional.core.domain.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessionalRepository extends JpaRepository<Professional, Long> {
}
