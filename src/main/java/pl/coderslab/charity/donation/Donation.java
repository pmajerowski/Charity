package pl.coderslab.charity.donation;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "donations_categories",
            joinColumns = { @JoinColumn(name = "donation_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;


    private String street;

    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    private String phone;

    @Column(name = "pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;


    @Column(name = "pick_up_time")
    @DateTimeFormat(pattern = "HH:mm")
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
