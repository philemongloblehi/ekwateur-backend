package fr.ekwateur.backend.particular.core.controller;

import fr.ekwateur.backend.common.enums.CustomerType;
import fr.ekwateur.backend.invoice.core.adapter.model.InvoiceDto;
import fr.ekwateur.backend.invoice.core.service.InvoiceService;
import fr.ekwateur.backend.particular.core.adapter.model.ParticularDto;
import fr.ekwateur.backend.particular.core.service.ParticularService;
import fr.ekwateur.backend.professional.core.adapter.model.ProfessionalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/particulars")
@RequiredArgsConstructor
public class ParticularController {

    private final ParticularService particularService;
    private final InvoiceService invoiceService;

    @PostMapping("/{id}/invoices")
    public ResponseEntity<InvoiceDto> invoice(@PathVariable Long id, @RequestBody InvoiceDto invoiceDto) {
        ParticularDto particularDto = particularService.findById(id);
        if (particularDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        invoiceDto.setCustomerId(id);
        InvoiceDto savedInvoiceDto = invoiceService.create(invoiceDto, CustomerType.PARTICULAR);
        return new ResponseEntity<>(savedInvoiceDto, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ParticularDto> create(@RequestBody ParticularDto particularDto) {
        ParticularDto savedParticular = particularService.create(particularDto);
        return new ResponseEntity<>(savedParticular, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ParticularDto>> findAll() {
        List<ParticularDto> particulars = particularService.findAll();
        return new ResponseEntity<>(particulars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticularDto> findById(@PathVariable Long id) {
        ParticularDto particularDto = particularService.findById(id);
        if (particularDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(particularDto, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticularDto> update(@PathVariable Long id, @RequestBody ParticularDto particularDto) {
        ParticularDto particularExisting = particularService.findById(id);
        if (particularExisting == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        particularDto.setId(id);
        ParticularDto updatedParticularDto = particularService.update(particularDto);
        return new ResponseEntity<>(updatedParticularDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ParticularDto particularExisting = particularService.findById(id);
        if (particularExisting == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        particularService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
