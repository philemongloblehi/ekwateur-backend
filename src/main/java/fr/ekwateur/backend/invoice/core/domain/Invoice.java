package fr.ekwateur.backend.invoice.core.domain;

import fr.ekwateur.backend.common.enums.EnergyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Long id;
    private String month;
    private int year;
    private EnergyType energyType;
    private Long customerId;
    private Double amount;
    private Double quantityConsumed;
}
