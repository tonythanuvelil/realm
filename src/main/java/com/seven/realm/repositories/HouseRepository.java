package com.seven.realm.repositories;

import com.seven.realm.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository
        extends JpaRepository<House, Long> {
}
