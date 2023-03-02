package it.corso.mygym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    @Column(unique = true)
    private String pIva;
    @OneToMany(mappedBy = "gym")
    private List<Subscription> subscriptions;
}
