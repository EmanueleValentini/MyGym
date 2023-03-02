package it.corso.mygym.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table (name = "gym")
public class Gym implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String pIva;
    @OneToMany(mappedBy = "gym")
    private List<Subscription> subscriptions;
}
