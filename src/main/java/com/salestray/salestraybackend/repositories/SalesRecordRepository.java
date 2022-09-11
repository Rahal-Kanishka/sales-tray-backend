package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.DTOs.SalesOnlyDTO;
import com.salestray.salestraybackend.entities.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRecordRepository extends JpaRepository<SalesRecord,Long> {

    //use Projection
    @Query("SELECT a.id as id,a.createdBy as createdBy,a.createdOn" +
            " as createdOn,a.updatedBy as updatedBy,a.updatedOn as updatedOn FROM SalesRecord a")
    public List<SalesOnlyDTO> getAllOnlySalesRecords();
}
