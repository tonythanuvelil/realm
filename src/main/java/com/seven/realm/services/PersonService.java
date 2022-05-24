package com.seven.realm.services;

import com.seven.realm.entities.House;
import com.seven.realm.entities.Person;
import com.seven.realm.repositories.HouseRepository;
import com.seven.realm.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final HouseRepository houseRepository;

    @Autowired
    public PersonService(PersonRepository personRepository,
                         HouseRepository houseRepository) {
        this.personRepository = personRepository;
        this.houseRepository = houseRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Transactional
    public void createPerson(Person person) {
        Optional<House> houseOptional = houseRepository.findById(person.getHouse().getId());
        if (houseOptional.isEmpty())
            throw new IllegalStateException(String.format("House not found with id %s", person.getHouse().getId()));
        personRepository.save(person) ;
    }
}
