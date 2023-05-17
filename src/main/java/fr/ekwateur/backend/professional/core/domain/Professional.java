package fr.ekwateur.backend.professional.core.domain;

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
@Document(collection = "professional")
public class Professional {

    @Id
    @Field(name = "professional_id")
    private Long id;
    private String reference;
    private String siretNumber;
    private String socialReason;
    private Double turnover;
}
