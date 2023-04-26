package fr.ekwateur.backend.particular.core.adapter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParticularDto {
    private Long id;
    private String reference;
    private String civility;
    private String lastname;
    private String firstname;
}
