package fr.ekwateur.backend.invoice.core.port;

import fr.ekwateur.backend.invoice.core.domain.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IInvoiceRepository extends MongoRepository<Invoice, Long> {
}
