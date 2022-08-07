package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByName(String name);
}
