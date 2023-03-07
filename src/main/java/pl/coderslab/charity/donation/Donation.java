package pl.coderslab.charity.donation;

import lombok.*;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "donations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @SequenceGenerator(
            name = "donation_sequence",
            sequenceName = "donation_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "donation_sequence"
    )
    private Long id;

    @Column
    @NotNull
    @Size(min = 1)
    private Integer quantity;

    @OneToMany
    private Set<Category> categories = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @Column
    @NotNull
    @Size(min=3, max=100)
    private String street;

    @Column
    @NotNull
    @Size(min=3, max=120)
    private String city;

    @Column
    @NotNull
    @Size(min=3, max=120)
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;

    @Column
    @Size(max=500)
    private String pickUpComment;

}
