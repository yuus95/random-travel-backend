package com.yscp.randomtravel.controller;

import com.yscp.randomtravel.domain.request.TravelRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/random-travel")
public class TravelController {

    @GetMapping("/{idx}")
    public String test(@PathVariable Integer idx) {
        return idx.toString();
    }

    @GetMapping
    public String test2(@ModelAttribute  TravelRequestDto requestDto) {
        System.out.println(requestDto.toString());
        return "Hello World";
    }
}
