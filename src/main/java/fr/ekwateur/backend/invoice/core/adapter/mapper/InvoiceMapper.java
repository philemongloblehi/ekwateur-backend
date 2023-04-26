package fr.ekwateur.backend.invoice.core.adapter.mapper;

import fr.ekwateur.backend.invoice.core.adapter.model.InvoiceDto;
import fr.ekwateur.backend.invoice.core.domain.Invoice;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public InvoiceDto entityToDto(Invoice invoice) {
        if (invoice == null) {
            return null;
        }
        return new InvoiceDto(
                invoice.getId(),
                invoice.getMonth(),
                invoice.getYear(),
                invoice.getEnergyType(),
                invoice.getCustomerId(),
                invoice.getAmount(),
                invoice.getQuantityConsumed()
        );
    }

    public Invoice dtoToEntity(InvoiceDto invoiceDto) {
        if (invoiceDto == null) {
            return null;
        }
        return new Invoice(
                invoiceDto.getId(),
                invoiceDto.getMonth(),
                invoiceDto.getYear(),
                invoiceDto.getEnergyType(),
                invoiceDto.getCustomerId(),
                invoiceDto.getAmount(),
                invoiceDto.getQuantityConsumed()
        );
    }
}
