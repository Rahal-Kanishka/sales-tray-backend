package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.entities.StockRecord;
import com.salestray.salestraybackend.repositories.StockRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "stock")
public class StockController implements BasicController<StockRecord> {

    @Autowired
    private StockRecordRepository stockRecordRepository;

    @Override
    @GetMapping(path="/all")
    public List<StockRecord> all() {
        return this.stockRecordRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public StockRecord update(StockRecord stockRecord) {
        return null;
    }

    @Override
    public StockRecord getById(Long id) {
        return null;
    }
}
