package com.seven.realm.repos;

import com.seven.realm.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository
        extends JpaRepository<Person, Long> {
}
