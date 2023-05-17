package fr.ekwateur.backend.professional.core.port;

import fr.ekwateur.backend.professional.core.domain.Professional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProfessionalRepository extends MongoRepository<Professional, Long> {
}
