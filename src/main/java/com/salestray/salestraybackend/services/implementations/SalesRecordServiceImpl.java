package com.salestray.salestraybackend.services.implementations;

import com.salestray.salestraybackend.DTOs.SalesOnlyDTO;
import com.salestray.salestraybackend.entities.Retailer;
import com.salestray.salestraybackend.entities.SaleType;
import com.salestray.salestraybackend.entities.SalesRecord;
import com.salestray.salestraybackend.exceptions.ObjectNotFoundException;
import com.salestray.salestraybackend.exceptions.ValidationException;
import com.salestray.salestraybackend.repositories.RetailerRepository;
import com.salestray.salestraybackend.repositories.SaleTypeRepository;
import com.salestray.salestraybackend.repositories.SalesRecordRepository;
import com.salestray.salestraybackend.repositories.StockRecordRepository;
import com.salestray.salestraybackend.services.SalesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SalesRecordServiceImpl implements SalesRecordService {

    @Autowired
    private SalesRecordRepository salesRecordRepository;

    @Autowired
    private StockRecordRepository stockRecordRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private SaleTypeRepository saleTypeRepository;

    @Override
    public SalesRecord createSalesRecord(SalesOnlyDTO salesOnlyDTO) {
        Retailer retailer = null;
        SaleType saleType = null;
        if (salesOnlyDTO == null) {
            throw new ValidationException("Data object can not be null");
        }
        if (salesOnlyDTO.getSoldPrice() <= 0) {
            throw new ValidationException("Sold price can not be zero or less than zero");
        }
        if (salesOnlyDTO.getSoldQuantity() <= 0) {
            throw new ValidationException("Sold quantity can not be zero or less than zero");
        }
        if (salesOnlyDTO.getRetailerId() <= 0) {
            throw new ValidationException("Retailer ID can not be zero or less than zero");
        }

        if (salesOnlyDTO.getSaleTypeId() <= 0) {
            throw new ValidationException("SaleType can not be zero or less than zero");
        }
        System.out.println("basic validation success");
        // finding the retailer
        retailer = this.retailerRepository.findById(salesOnlyDTO.getRetailerId()).orElse(null);
        if (retailer == null) {
            throw new ObjectNotFoundException("retailerID " + salesOnlyDTO.getRetailerId());
        }
        saleType = this.saleTypeRepository.findById((long) salesOnlyDTO.getSaleTypeId()).orElse(null);
        if (saleType == null) {
            throw new ObjectNotFoundException("saleTypeID " + salesOnlyDTO.getSaleTypeId());
        }

        SalesRecord salesRecord = new SalesRecord();
        salesRecord.setCreatedBy(1L); //todo: need to implement user authentication
        salesRecord.setCreatedOn(new Date());
        salesRecord.setRetailer(retailer);
        salesRecord.setSaleType(saleType);
        return this.salesRecordRepository.save(salesRecord);
    }

    @Override
    public SalesRecord updateSalesRecord(SalesOnlyDTO salesOnlyDTO) {
        return null;
    }

    @Override
    public Boolean deleteSalesRecord(Long salesRecordId) {
        return null;
    }
}
