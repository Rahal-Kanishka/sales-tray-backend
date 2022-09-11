package com.salestray.salestraybackend.DTOs;

import com.salestray.salestraybackend.entities.SaleType;
import com.salestray.salestraybackend.entities.SalesRecord;
import com.salestray.salestraybackend.entities.StockRecord;

import java.util.Date;

public interface SalesWithStockDetailsDTO {

    Long getId();

    SalesRecord getSalesRecord();

    StockRecord getStockRecord();

    Long getSoldQuantity();

    Double getSoldPrice();

    Date getCreatedOn();

    Long getCreatedBy();

    Date getUpdatedOn();

    Long getUpdatedBy();

    Long getRetailerId();

    SaleType getSaleType();
}
