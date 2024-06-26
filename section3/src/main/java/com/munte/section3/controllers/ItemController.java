package com.munte.section3.controllers;

import com.munte.section3.business.ItemBusinessService;
import com.munte.section3.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping()
    public Item getDummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/from-business-service")
    public Item itemFromBusinessService() {
        return businessService.retrieveHardCodedItem();
    }

    @GetMapping("/all-items")
    public List<Item> retrieveAllItems() {
        return businessService.retrieveAllItems();
    }

}
