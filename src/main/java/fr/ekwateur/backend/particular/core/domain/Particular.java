package fr.ekwateur.backend.particular.core.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "particular")
public class Particular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "particular_id")
    private Long id;
    private String reference;
    private String civility;
    private String lastname;
    private String firstname;
}
