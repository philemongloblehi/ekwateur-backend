package fr.ekwateur.backend.invoice.infrastructure.repository;

import fr.ekwateur.backend.common.enums.EnergyType;
import fr.ekwateur.backend.invoice.core.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceRepositoryTest {

    @Test
    void create() throws Exception {
        Invoice buildInvoice = buildInvoice();
        Invoice savedInvoice = savedInvoice();

        InvoiceRepository invoiceRepository = Mockito.mock(InvoiceRepository.class);
        Mockito.when(invoiceRepository.create(buildInvoice)).thenReturn(savedInvoice);

        Invoice invoice = invoiceRepository.create(buildInvoice);

        assertNotNull(invoice);
        assertEquals(1L, invoice.getId());
        assertEquals(12.0, invoice.getAmount());
        assertEquals("January", invoice.getMonth());
        assertEquals(2023, invoice.getYear());
        assertEquals(100L, invoice.getCustomerId());
        assertEquals("ELECTRICITY", invoice.getEnergyType().toString());
        assertEquals(450.0, invoice.getQuantityConsumed());
    }

    private Invoice buildInvoice() {
        Invoice invoice = new Invoice();
        invoice.setAmount(12.0);
        invoice.setMonth("January");
        invoice.setYear(2023);
        invoice.setEnergyType(EnergyType.ELECTRICITY);
        invoice.setCustomerId(100L);
        invoice.setQuantityConsumed(450.0);
        return invoice;
    }

    private Invoice savedInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId(1L);
        invoice.setAmount(12.0);
        invoice.setMonth("January");
        invoice.setYear(2023);
        invoice.setEnergyType(EnergyType.ELECTRICITY);
        invoice.setCustomerId(100L);
        invoice.setQuantityConsumed(450.0);
        return invoice;
    }
}
