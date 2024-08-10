package com.yscp.randomtravel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random-travel")
public class TravelController {

    @GetMapping("/{idx}")
    public String test(@PathVariable Integer idx) {
        return idx.toString();
    }

    @GetMapping
    public String test2() {
        return "Hello World";
    }
}
