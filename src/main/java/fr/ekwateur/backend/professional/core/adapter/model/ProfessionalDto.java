package fr.ekwateur.backend.professional.core.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfessionalDto {
    private Long id;
    private String reference;
    private String siretNumber;
    private String socialReason;
    private Double turnover;
}
