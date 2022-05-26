package com.seven.realm.entities;

import com.seven.realm.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "persons")
public class Person extends BaseEntity {
    @Id
    @SequenceGenerator(
            name = "person_id_sequence",
            sequenceName = "person_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_id_sequence"
    )
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;

    @Column(nullable = false)
    private LocalDate dob;

    @Transient
    private Integer age;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Status status = Status.UNKNOWN;

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
