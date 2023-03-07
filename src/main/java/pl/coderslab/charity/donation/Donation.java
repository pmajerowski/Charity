package pl.coderslab.charity.donation;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private Integer quantity;

    @OneToMany
    private List<Category> categories = new ArrayList<>();

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

    @Column(name = "zip_code")
    @NotNull
    @Size(min=3, max=120)
    private String zipCode;

    @Column(name = "pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @Column(name = "pick_up_time")
    @DateTimeFormat(pattern = "hh-mm")
    private LocalTime pickUpTime;

    @Column(name = "pick_up_comment")
    @Size(max=500)
    private String pickUpComment;

    public Donation(Long id, Integer quantity, String street, String city, String zipCode) {
        this.id = id;
        this.quantity = quantity;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
