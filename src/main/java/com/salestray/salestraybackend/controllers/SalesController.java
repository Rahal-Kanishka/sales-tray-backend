package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.DTOs.SalesOnlyDTO;
import com.salestray.salestraybackend.DTOs.SalesWithStockDetailsDTO;
import com.salestray.salestraybackend.DTOs.requestDTOs.CreateSalesRecordDTO;
import com.salestray.salestraybackend.entities.SalesRecord;
import com.salestray.salestraybackend.entities.SalesWithStockDetail;
import com.salestray.salestraybackend.repositories.SalesRecordRepository;
import com.salestray.salestraybackend.repositories.SalesWithStockDetailRepository;
import com.salestray.salestraybackend.repositories.StockRecordRepository;
import com.salestray.salestraybackend.services.SalesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "sales")
@CrossOrigin(origins = "*")
public class SalesController implements BasicController<SalesRecord> {

    @Autowired
    private SalesRecordRepository salesRecordRepository;

    @Autowired
    private StockRecordRepository stockRecordRepository;

    @Autowired
    private SalesWithStockDetailRepository salesWithStockDetailRepository;

    @Autowired
    SalesRecordService salesRecordService;


    @Override
    @GetMapping(path="/all")
    public List<SalesRecord> all() {
        return this.salesRecordRepository.findAll();
    }

    @GetMapping(path="/all_sales_only")
    public List<SalesOnlyDTO> findAllSalesOnly() {
        return this.salesRecordRepository.getAllOnlySalesRecords();
    }

    @GetMapping(path="/all_sales_with_stock")
    public List<SalesWithStockDetailsDTO> findAllSalesWithStock() {
        return this.salesWithStockDetailRepository.getAllSalesWithStockRecords();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public SalesRecord update(SalesRecord salesRecord) {
        return null;
    }

    @Override
    public SalesRecord getById(Long id) {
        return null;
    }

    @PostMapping(path="/add")
    public SalesWithStockDetail add(@RequestBody CreateSalesRecordDTO createSalesRecordDTO){
        return this.salesRecordService.createSalesRecord(createSalesRecordDTO);
    }
}
