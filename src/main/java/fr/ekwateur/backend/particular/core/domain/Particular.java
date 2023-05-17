package fr.ekwateur.backend.particular.core.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "particular")
public class Particular {

    @Id
    @Field(name = "particular_id")
    private Long id;
    private String reference;
    private String civility;
    private String lastname;
    private String firstname;
}
