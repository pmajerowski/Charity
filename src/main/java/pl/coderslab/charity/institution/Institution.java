package pl.coderslab.charity.institution;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "institutions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Institution {
    @Id
    @SequenceGenerator(
            name = "institution_sequence",
            sequenceName = "institution_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "institution_sequence"
    )
    private Long id;

    @Size(min = 4, max = 255)
    private String name;

    @Size(min = 20, max = 1000)
    private String description;

    public Institution(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
