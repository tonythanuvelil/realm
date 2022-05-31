package com.seven.realm.repos;

import com.seven.realm.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository
        extends JpaRepository<House, Long> {
}
