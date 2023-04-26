package fr.ekwateur.backend.invoice.core.port;

import fr.ekwateur.backend.common.enums.CustomerType;
import fr.ekwateur.backend.invoice.core.adapter.model.InvoiceDto;

public interface IInvoiceService {
    InvoiceDto create(InvoiceDto invoiceDto, CustomerType customerType);
}
