package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.entities.SaleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTypeRepository extends JpaRepository<SaleType,Long> {
}
