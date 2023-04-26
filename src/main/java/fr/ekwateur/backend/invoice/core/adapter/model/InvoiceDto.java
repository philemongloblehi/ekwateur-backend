package fr.ekwateur.backend.invoice.core.adapter.model;

import fr.ekwateur.backend.common.enums.EnergyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvoiceDto {
    private Long id;
    private String month;
    private int year;
    private EnergyType energyType;
    private Long customerId;
    private Double amount;
    private Double quantityConsumed;
}
