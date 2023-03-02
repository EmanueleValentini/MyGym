package it.corso.mygym.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table (name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,nullable = false)
    private String name;
    @Column(length = 30,nullable = false)
    private String surname;
    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(nullable = false)
    private boolean medicalCert;
    @Column(nullable = false)
    private boolean activated;
    @OneToMany(mappedBy = "user")
    private List<Subscription> subscriptions;
}
