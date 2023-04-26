package fr.ekwateur.backend.invoice.infrastructure.repository;

import fr.ekwateur.backend.invoice.core.domain.Invoice;
import fr.ekwateur.backend.invoice.core.port.IInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InvoiceRepository {
    private final IInvoiceRepository repository;

    public Invoice create(Invoice invoice) {
        return repository.save(invoice);
    }
}
