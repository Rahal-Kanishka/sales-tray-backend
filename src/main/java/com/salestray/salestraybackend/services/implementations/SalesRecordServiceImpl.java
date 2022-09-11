package com.salestray.salestraybackend.services.implementations;

import com.salestray.salestraybackend.DTOs.SalesOnlyDTO;
import com.salestray.salestraybackend.DTOs.SalesWithStockDetailsDTO;
import com.salestray.salestraybackend.DTOs.requestDTOs.CreateSalesRecordDTO;
import com.salestray.salestraybackend.entities.*;
import com.salestray.salestraybackend.exceptions.ObjectNotFoundException;
import com.salestray.salestraybackend.exceptions.ValidationException;
import com.salestray.salestraybackend.repositories.*;
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
    private SalesWithStockDetailRepository salesWithStockDetailRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private SaleTypeRepository saleTypeRepository;

    @Override
    public SalesWithStockDetail createSalesRecord(CreateSalesRecordDTO createSalesRecordDTO) {
        Retailer retailer = null;
        SaleType saleType = null;
        StockRecord stockRecord = null;
        if (createSalesRecordDTO == null) {
            throw new ValidationException("Data object can not be null");
        }
        if (createSalesRecordDTO.getSoldPrice() <= 0) {
            throw new ValidationException("Sold price can not be zero or less than zero");
        }
        if (createSalesRecordDTO.getSoldQuantity() <= 0) {
            throw new ValidationException("Sold quantity can not be zero or less than zero");
        }
        if (createSalesRecordDTO.getRetailerId() <= 0) {
            throw new ValidationException("Retailer ID can not be zero or less than zero");
        }
        if (createSalesRecordDTO.getSaleTypeId() <= 0) {
            throw new ValidationException("SaleType can not be zero or less than zero");
        }
        if (createSalesRecordDTO.getStockRecordId() <= 0) {
            throw new ValidationException("StockRecord ID can not be zero or less than zero");
        }
        // get the stock record
        stockRecord = this.stockRecordRepository.findById(createSalesRecordDTO.getStockRecordId()).orElse(null);
        if (stockRecord == null){
            throw new ObjectNotFoundException("stockRecordId: "+ createSalesRecordDTO.getStockRecordId());
        }
        System.out.println("basic validation success");
        // finding the retailer
        retailer = this.retailerRepository.findById(createSalesRecordDTO.getRetailerId()).orElse(null);
        if (retailer == null) {
            throw new ObjectNotFoundException("retailerID " + createSalesRecordDTO.getRetailerId());
        }
        saleType = this.saleTypeRepository.findById((long) createSalesRecordDTO.getSaleTypeId()).orElse(null);
        if (saleType == null) {
            throw new ObjectNotFoundException("saleTypeID " + createSalesRecordDTO.getSaleTypeId());
        }

        // create a record in sales
        SalesRecord salesRecord = new SalesRecord();
        salesRecord.setCreatedBy(1L); //todo: need to implement user authentication
        salesRecord.setCreatedOn(new Date());
        salesRecord.setRetailer(retailer);
        salesRecord.setSaleType(saleType);
        salesRecord = this.salesRecordRepository.save(salesRecord);

        // create a record in sales-stock-details
        SalesWithStockDetail salesWithStockDetail = new SalesWithStockDetail();
        salesWithStockDetail.setCreatedOn(new Date());
        salesWithStockDetail.setCreatedBy(1L);
        salesWithStockDetail.setSalesRecord(salesRecord);
        salesWithStockDetail.setStockRecord(stockRecord);
        salesWithStockDetail.setSoldPrice(createSalesRecordDTO.getSoldPrice());
        salesWithStockDetail.setSoldQuantity(createSalesRecordDTO.getSoldQuantity());
        salesWithStockDetail.setGrossSale(createSalesRecordDTO.getSoldPrice() * createSalesRecordDTO.getSoldQuantity());
        salesWithStockDetail.setDiscount(createSalesRecordDTO.getDiscount());
        return this.salesWithStockDetailRepository.save(salesWithStockDetail);
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
