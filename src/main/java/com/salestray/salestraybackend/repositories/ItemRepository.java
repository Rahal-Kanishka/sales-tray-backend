package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
