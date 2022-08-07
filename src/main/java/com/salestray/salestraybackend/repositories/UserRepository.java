package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
