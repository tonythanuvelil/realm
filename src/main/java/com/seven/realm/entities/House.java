package com.seven.realm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "houses")
public class House extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "house_id_sequence",
            sequenceName = "house_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "house_id_sequence"
    )
    @Column(updatable = false)
    private Long id;

    @Column(unique = true)
    private String name;

    private String words;

    private LocalDate established;

    @JsonIgnore
    @OneToOne(mappedBy = "house")
    @JoinColumn(name = "person_id")
    private Person person;
}



