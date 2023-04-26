package fr.ekwateur.backend.invoice.core.service;

import fr.ekwateur.backend.common.enums.CustomerType;
import fr.ekwateur.backend.common.enums.EnergyType;
import fr.ekwateur.backend.invoice.core.adapter.mapper.InvoiceMapper;
import fr.ekwateur.backend.invoice.core.adapter.model.InvoiceDto;
import fr.ekwateur.backend.invoice.core.domain.Invoice;
import fr.ekwateur.backend.invoice.core.port.IInvoiceService;
import fr.ekwateur.backend.invoice.infrastructure.repository.InvoiceRepository;
import fr.ekwateur.backend.particular.core.domain.Particular;
import fr.ekwateur.backend.particular.infrastructure.repository.ParticularRepository;
import fr.ekwateur.backend.professional.core.domain.Professional;
import fr.ekwateur.backend.professional.infrastructure.repository.ProfessionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static fr.ekwateur.backend.common.enums.CustomerType.PARTICULAR;
import static fr.ekwateur.backend.common.enums.CustomerType.PROFESSIONAL;

@Service
@RequiredArgsConstructor
public class InvoiceService implements IInvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ProfessionalRepository professionalRepository;
    private final ParticularRepository particularRepository;
    private final InvoiceMapper mapper;

    @Override
    public InvoiceDto create(InvoiceDto invoiceDto, CustomerType customerType) {
        Double amount = 0.0;
        if (PARTICULAR.equals(customerType)) {
            amount = amountParticularInvoice(invoiceDto);
        } else if (PROFESSIONAL.equals(customerType)) {
            amount = amountProfessionalInvoice(invoiceDto);
        }
        invoiceDto.setAmount(amount);
        Invoice entity = mapper.dtoToEntity(invoiceDto);
        Invoice savedInvoice = invoiceRepository.create(entity);
        return mapper.entityToDto(savedInvoice);
    }

    private Double amountProfessionalInvoice(InvoiceDto invoiceDto) {
        Professional professional = professionalRepository.findById(invoiceDto.getCustomerId());
        if (professional.getTurnover() > 1_000_000) {
            return switch (invoiceDto.getEnergyType()) {
                case ELECTRICITY -> invoiceDto.getQuantityConsumed() * 0.114;
                case GAS -> invoiceDto.getQuantityConsumed() * 0.111;
                default -> throw new IllegalStateException("Unexpected value: " + invoiceDto.getEnergyType());
            };
        } else if (professional.getTurnover() < 1_000_000) {
            return switch (invoiceDto.getEnergyType()) {
                case ELECTRICITY -> invoiceDto.getQuantityConsumed() * 0.118;
                case GAS -> invoiceDto.getQuantityConsumed() * 0.113;
                default -> throw new IllegalStateException("Unexpected value: " + invoiceDto.getEnergyType());
            };
        }
        return 0.0;
    }

    private Double amountParticularInvoice(InvoiceDto invoiceDto) {
        return switch (invoiceDto.getEnergyType()) {
            case ELECTRICITY -> invoiceDto.getQuantityConsumed() * 0.121;
            case GAS -> invoiceDto.getQuantityConsumed() * 0.115;
            default -> throw new IllegalStateException("Unexpected value: " + invoiceDto.getEnergyType());
        };
    }
}
