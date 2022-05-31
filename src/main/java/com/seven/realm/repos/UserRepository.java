package com.seven.realm.repos;

import com.seven.realm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByUsername(String id);
}
