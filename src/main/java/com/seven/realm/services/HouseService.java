package com.seven.realm.services;

import com.seven.realm.entities.House;
import com.seven.realm.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public void createHouse(House house) {
        houseRepository.save(house);
    }

    public List<House> getHouses() {
        return houseRepository.findAll();
    }
}
