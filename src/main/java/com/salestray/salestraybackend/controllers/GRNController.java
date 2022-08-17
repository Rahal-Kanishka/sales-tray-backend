package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.entities.GRN;
import com.salestray.salestraybackend.entities.Item;
import com.salestray.salestraybackend.repositories.GRNRepository;
import com.salestray.salestraybackend.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "grn")
public class GRNController {


    @Autowired
    private GRNRepository grnRepository;

    @GetMapping(path="/all")
    public @ResponseBody List<GRN> allGRNEntries() {
        List<GRN> result = this.grnRepository.findAll();
        return result;
    }
}
