package fr.ekwateur.backend.invoice.core.service;

import fr.ekwateur.backend.common.enums.CustomerType;
import fr.ekwateur.backend.common.enums.EnergyType;
import fr.ekwateur.backend.invoice.core.adapter.mapper.InvoiceMapper;
import fr.ekwateur.backend.invoice.core.adapter.model.InvoiceDto;
import fr.ekwateur.backend.invoice.core.domain.Invoice;
import fr.ekwateur.backend.invoice.infrastructure.repository.InvoiceRepository;
import fr.ekwateur.backend.particular.infrastructure.repository.ParticularRepository;
import fr.ekwateur.backend.professional.core.domain.Professional;
import fr.ekwateur.backend.professional.infrastructure.repository.ProfessionalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InvoiceServiceTest {
    private InvoiceRepository invoiceRepository;
    private ProfessionalRepository professionalRepository;
    private ParticularRepository particularRepository;
    private InvoiceMapper mapper;

    private InvoiceService invoiceService;

    @BeforeEach
    void setUp() throws Exception {
        invoiceRepository = mock(InvoiceRepository.class);
        professionalRepository = mock(ProfessionalRepository.class);
        particularRepository = mock(ParticularRepository.class);
        mapper = mock(InvoiceMapper.class);
        invoiceService = new InvoiceService(invoiceRepository, professionalRepository, particularRepository, mapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        invoiceRepository = null;
        professionalRepository = null;
        particularRepository = null;
        mapper = null;
        invoiceService = null;
    }

    @Test
    void createInvoice_particular() throws Exception {
        Invoice entity = buildInvoiceEntity();
        InvoiceDto dto = buildInvoiceDto();
        when(invoiceRepository.create(entity)).thenReturn(entity);
        when(mapper.dtoToEntity(any())).thenReturn(entity);
        when(mapper.entityToDto(any())).thenReturn(dto);

        InvoiceDto result = invoiceService.create(dto, CustomerType.PARTICULAR);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(20L, result.getId());
        Assertions.assertEquals("April", result.getMonth());
        Assertions.assertEquals(2023, result.getYear());
        Assertions.assertEquals("GAS", result.getEnergyType().toString());
        Assertions.assertEquals(100L, result.getCustomerId());
        Assertions.assertEquals(97.75, result.getAmount());
        Assertions.assertEquals(850.0, result.getQuantityConsumed());

    }

    private Professional buildProfessional() {
        Professional professional = new Professional();
        professional.setId(1L);
        professional.setReference("EKW-12345678");
        professional.setTurnover(12.0);
        professional.setSiretNumber("RCC-001");
        professional.setSocialReason("EKWATEUR");
        return professional;
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
