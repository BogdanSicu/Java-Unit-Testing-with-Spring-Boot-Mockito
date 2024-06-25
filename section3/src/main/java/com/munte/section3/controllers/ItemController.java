package com.munte.section3.controllers;

import com.munte.section3.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    @GetMapping()
    public Item getDummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

}
