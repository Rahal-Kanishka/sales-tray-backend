package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.DTOs.SalesOnlyDTO;
import com.salestray.salestraybackend.entities.SalesRecord;
import com.salestray.salestraybackend.repositories.SalesRecordRepository;
import com.salestray.salestraybackend.repositories.StockRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "sales")
public class SalesController implements BasicController<SalesRecord> {

    @Autowired
    private SalesRecordRepository salesRecordRepository;

    @Autowired
    private StockRecordRepository stockRecordRepository;


    @Override
    @GetMapping(path="/all")
    public List<SalesRecord> all() {
        return this.salesRecordRepository.findAll();
    }

    @GetMapping(path="/all_sales_only")
    public List<SalesOnlyDTO> findAllSalesOnly() {
        return this.salesRecordRepository.getAllOnlySalesRecords();
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
}
