package com.seven.realm.controllers;

import com.seven.realm.entities.House;
import com.seven.realm.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createHouse(@RequestBody House house) {
        houseService.createHouse(house);
    }
}
