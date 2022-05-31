package com.seven.realm.services;

import com.seven.realm.entities.House;
import com.seven.realm.entities.Person;
import com.seven.realm.repos.HouseRepository;
import com.seven.realm.repos.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {
    private final PersonRepository personRepository;
    private final HouseRepository houseRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void createPerson(Person person) {
        Optional<House> houseOptional = houseRepository.findById(person.getHouse().getId());
        if (houseOptional.isEmpty())
            throw new IllegalStateException(String.format("House not found with id %s", person.getHouse().getId()));
        personRepository.save(person) ;
    }
}
