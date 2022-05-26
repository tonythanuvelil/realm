package com.seven.realm.controllers;

import com.seven.realm.entities.House;
import com.seven.realm.services.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "house")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getHouses() {
        return houseService.getHouses();
    }

    @PostMapping
    public void createHouse(@RequestBody House house) {
        houseService.createHouse(house);
    }
}
