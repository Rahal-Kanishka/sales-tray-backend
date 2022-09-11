package com.salestray.salestraybackend.repositories;

import com.salestray.salestraybackend.DTOs.SalesWithStockDetailsDTO;
import com.salestray.salestraybackend.entities.SalesWithStockDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesWithStockDetailRepository extends JpaRepository<SalesWithStockDetail, Long> {

    @Query("SELECT a.id as id,a.salesRecord as salesRecord,a.stockRecord as stockRecord, a.soldQuantity as soldQuantity,a.soldPrice as soldPrice,a.grossSale as grossSale,a.discount as discount, a.createdBy as createdBy,a.createdOn" +
            " as createdOn,a.updatedBy as updatedBy,a.updatedOn as updatedOn FROM SalesWithStockDetail a")
    public List<SalesWithStockDetailsDTO> getAllSalesWithStockRecords();
}
