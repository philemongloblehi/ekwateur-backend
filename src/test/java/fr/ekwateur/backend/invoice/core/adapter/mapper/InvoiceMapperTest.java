package fr.ekwateur.backend.invoice.core.adapter.mapper;

import fr.ekwateur.backend.common.enums.EnergyType;
import fr.ekwateur.backend.invoice.core.adapter.model.InvoiceDto;
import fr.ekwateur.backend.invoice.core.domain.Invoice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceMapperTest {

    private InvoiceMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        mapper = new InvoiceMapper();
    }

    @AfterEach
    void tearDown() throws Exception {
        mapper = null;
    }

    @Test
    void entityToDto_should_return_dto() throws Exception {
        Invoice invoiceEntity = buildInvoiceEntity();
        InvoiceDto invoiceDto = mapper.entityToDto(invoiceEntity);

        assertNotNull(invoiceDto);
        assertEquals(10L, invoiceDto.getId());
        assertEquals(124.0, invoiceDto.getAmount());
        assertEquals("January", invoiceDto.getMonth());
        assertEquals(2022, invoiceDto.getYear());
        assertEquals("ELECTRICITY", invoiceDto.getEnergyType().toString());
        assertEquals(100L, invoiceDto.getCustomerId());
        assertEquals(450.0, invoiceDto.getQuantityConsumed());

    }

    @Test
    void entityToDto_should_return_null() throws Exception {
        InvoiceDto invoiceDto = mapper.entityToDto(null);

        assertNull(invoiceDto);
    }

    @Test
    void dtoToEntity_should_return_entity() throws Exception {
        InvoiceDto invoiceDto = buildInvoiceDto();
        Invoice invoiceEntity = mapper.dtoToEntity(invoiceDto);

        assertNotNull(invoiceEntity);
        assertEquals(20L, invoiceEntity.getId());
        assertEquals(125.0, invoiceEntity.getAmount());
        assertEquals("April", invoiceEntity.getMonth());
        assertEquals(2023, invoiceEntity.getYear());
        assertEquals("GAS", invoiceEntity.getEnergyType().toString());
        assertEquals(100L, invoiceEntity.getCustomerId());
        assertEquals(850.0, invoiceEntity.getQuantityConsumed());
    }

    @Test
    void dtoToEntity_should_return_null() throws Exception {
        Invoice invoiceEntity = mapper.dtoToEntity(null);

        assertNull(invoiceEntity);
    }

    private Invoice buildInvoiceEntity() {
        Invoice entity = new Invoice();
        entity.setId(10L);
        entity.setAmount(124.0);
        entity.setMonth("January");
        entity.setYear(2022);
        entity.setEnergyType(EnergyType.ELECTRICITY);
        entity.setCustomerId(100L);
        entity.setQuantityConsumed(450.0);
        return entity;
    }

    private InvoiceDto buildInvoiceDto() {
        InvoiceDto dto = new InvoiceDto();
        dto.setId(20L);
        dto.setAmount(125.0);
        dto.setMonth("April");
        dto.setYear(2023);
        dto.setEnergyType(EnergyType.GAS);
        dto.setCustomerId(100L);
        dto.setQuantityConsumed(850.0);
        return dto;
    }
}
