package tn.esprit.yasmineajailia4ds3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numPiste;

    String namePiste;
    @Enumerated(EnumType.STRING)
    Color color;
    int length;
    int slope;

    @ManyToMany
    Set<Skier> skiers;
}
