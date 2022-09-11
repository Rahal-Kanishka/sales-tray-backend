package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.entities.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerRepository extends JpaRepository<Retailer, Long> {
}
