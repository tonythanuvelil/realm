package com.seven.realm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "house")
public class House extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "house_sequence",
            sequenceName = "house_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "house_sequence"
    )
    private Long id;

    @Column(unique = true)
    private String name;

    private String words;

    private LocalDate established;

    @JsonIgnore
    @OneToOne(mappedBy = "house")
    private Person person;
}



