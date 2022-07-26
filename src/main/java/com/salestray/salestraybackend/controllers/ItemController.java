package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.entities.Category;
import com.salestray.salestraybackend.entities.Item;
import com.salestray.salestraybackend.repositories.CategoryRepository;
import com.salestray.salestraybackend.repositories.ItemRepository;
import com.salestray.salestraybackend.DTOs.requestDTOs.CreateItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "item")
public class ItemController implements BasicController<Item>{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /*@GetMapping(path="/all")
    public @ResponseBody List<Item> allCategories() {
        List<Item> result = itemRepository.findAll();
        return result;
    }*/

    /*@GetMapping(path="/findCategoryByItemID")
    public @ResponseBody Category findCategoryByItemID(@RequestParam Long itemId) {
        Item result = itemRepository.findById(itemId).orElse(null);
        return result.getCategory();
    }*/

    /*@GetMapping(path="/add")
    public @ResponseBody Item addItem(@RequestBody Item item) {
        item.setCreatedOn(new Date());
        Item result = itemRepository.save(item);
        return result;
    }*/

    @Override
    @GetMapping(path="/all")
    public List<Item> all() {
        List<Item> result = itemRepository.findAll();
        return result;
    }

    @PostMapping(path="/add")
    public @ResponseBody Item addUsingDTO(@RequestBody CreateItemDTO createItemDTO) throws Exception {
        Item result = null;
        // to set the category
        if (createItemDTO.getCategoryId() > 0) {
            Category category = this.categoryRepository.findById(createItemDTO.getCategoryId()).orElse(null);
            if (category == null){
                throw new Exception("Category not found");
            } else {
                Item item = new Item();
                item.setCategory(category);
                item.setName(createItemDTO.getName());
                item.setCode(createItemDTO.getCode());
                item.setPackingSize(createItemDTO.getPackingSize());
                item.setCreatedOn(new Date());
                result = itemRepository.save(item);
            }
        }
        return result;
    }

    @Override
    @DeleteMapping(path="/update")
    public void delete(Long id) {

    }

    @Override
    @PutMapping(path="/update")
    public Item update(@RequestBody Item item) {
        item.setUpdatedOn(new Date());
        Item result = itemRepository.save(item);
        return result;
    }

    @Override
    @GetMapping(path="/findCategoryByItemID")
    public @ResponseBody Item getById(@RequestParam Long id) {
        Item result = itemRepository.findById(id).orElse(null);
        return result;
    }
}
