package com.seven.realm.controllers;

import com.seven.realm.entities.Person;
import com.seven.realm.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }
}
