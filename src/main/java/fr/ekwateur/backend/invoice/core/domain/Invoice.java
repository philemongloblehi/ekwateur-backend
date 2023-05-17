package fr.ekwateur.backend.invoice.core.domain;

import fr.ekwateur.backend.common.enums.EnergyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "invoice")
public class Invoice {
    @Id
    @Field(name = "invoice_id")
    private Long id;
    private String month;
    private int year;
    private EnergyType energyType;
    private Long customerId;
    private Double amount;
    private Double quantityConsumed;
}
