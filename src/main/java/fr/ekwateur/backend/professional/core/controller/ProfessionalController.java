package fr.ekwateur.backend.professional.core.controller;

import fr.ekwateur.backend.common.enums.CustomerType;
import fr.ekwateur.backend.invoice.core.adapter.model.InvoiceDto;
import fr.ekwateur.backend.invoice.core.service.InvoiceService;
import fr.ekwateur.backend.professional.core.adapter.model.ProfessionalDto;
import fr.ekwateur.backend.professional.core.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
@RequiredArgsConstructor
public class ProfessionalController {

    private final ProfessionalService professionalService;
    private final InvoiceService invoiceService;

    @PostMapping("/{id}/invoices")
    public ResponseEntity<InvoiceDto> invoice(@PathVariable Long id, @RequestBody InvoiceDto invoiceDto) {
        ProfessionalDto professional = professionalService.findById(id);
        if (professional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        invoiceDto.setCustomerId(id);
        InvoiceDto savedInvoiceDto = invoiceService.create(invoiceDto, CustomerType.PROFESSIONAL);
        return new ResponseEntity<>(savedInvoiceDto, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ProfessionalDto> create(@RequestBody ProfessionalDto professionalDto) {
        ProfessionalDto savedProfessional = professionalService.create(professionalDto);
        return new ResponseEntity<>(savedProfessional, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalDto>> findAll() {
        List<ProfessionalDto> professionals = professionalService.findAll();
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalDto> findById(@PathVariable Long id) {
        ProfessionalDto professionalDto = professionalService.findById(id);
        if (professionalDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(professionalDto, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalDto> update(@PathVariable Long id, @RequestBody ProfessionalDto professionalDto) {
        ProfessionalDto professionalExisting = professionalService.findById(id);
        if (professionalExisting == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        professionalDto.setId(id);
        ProfessionalDto updatedProfessionalDto = professionalService.update(professionalDto);
        return new ResponseEntity<>(updatedProfessionalDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ProfessionalDto professionalExisting = professionalService.findById(id);
        if (professionalExisting == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        professionalService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
