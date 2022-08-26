package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.entities.StockRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRecordRepository extends JpaRepository<StockRecord,Long> {
}
