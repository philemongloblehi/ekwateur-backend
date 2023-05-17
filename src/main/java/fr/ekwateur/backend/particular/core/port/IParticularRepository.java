package fr.ekwateur.backend.particular.core.port;

import fr.ekwateur.backend.particular.core.domain.Particular;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IParticularRepository extends MongoRepository<Particular, Long> {
}
