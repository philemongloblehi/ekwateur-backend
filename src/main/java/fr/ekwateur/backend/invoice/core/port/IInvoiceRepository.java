package fr.ekwateur.backend.invoice.core.port;

import fr.ekwateur.backend.invoice.core.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
}
