package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.entities.Category;
import com.salestray.salestraybackend.entities.Item;
import com.salestray.salestraybackend.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(path="/all")
    public @ResponseBody List<Item> allCategories() {
        List<Item> result = itemRepository.findAll();
        return result;
    }

    @GetMapping(path="/findCategoryByItemID")
    public @ResponseBody Category findCategoryByItemID(@RequestParam Long itemId) {
        Item result = itemRepository.findById(itemId).orElse(null);
        return result.getCategory();
    }
}
