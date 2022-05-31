package com.seven.realm.services;

import com.seven.realm.entities.House;
import com.seven.realm.repos.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HouseService {

    private final HouseRepository houseRepository;

    public void createHouse(House house) {
        houseRepository.save(house);
    }

    public List<House> getHouses() {
        return houseRepository.findAll();
    }
}
