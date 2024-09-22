package com.yscp.randomtravel.controller;

import com.yscp.randomtravel.domain.request.travel.RandomTravelItemResponse;
import com.yscp.randomtravel.domain.request.travel.RandomTravelResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/random-travel")
public class TravelController {

    @GetMapping("/{idx}")
    public String test(@PathVariable Integer idx) {
        return idx.toString();
    }

    @GetMapping
    public RandomTravelResponseDto fetchRandomTravelResponseDto() {
        List<RandomTravelItemResponse> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new RandomTravelItemResponse("이름없음" + i, "서울 어딘가 " + i));
        }

        return new RandomTravelResponseDto(items);
    }
}
