package com.yscp.randomtravel.controller;

import com.yscp.randomtravel.domain.request.travel.RandomTravelItemResponse;
import com.yscp.randomtravel.domain.request.travel.RandomTravelResponseDto;
import com.yscp.randomtravel.domain.response.RandomTravelCountResponseDto;
import org.springframework.web.bind.annotation.*;

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
    public RandomTravelResponseDto fetchRandomTravelResponseDto(@RequestParam Integer page, @RequestParam Integer limit) {
        List<RandomTravelItemResponse> items = new ArrayList<>();
        Integer customPage = getPage(page);
        for (int i = (customPage - 1) * limit; i < customPage * limit; i++) {
            items.add(new RandomTravelItemResponse("이름없음" + i, "서울 어딘가 " + i));
        }

        return new RandomTravelResponseDto(items);
    }

    @GetMapping("/count")
    public RandomTravelCountResponseDto fetchRandomTravelCountResponseDto() {
        return new RandomTravelCountResponseDto(1000);
    }

    private Integer getPage(Integer page) {
        if (page == null || page < 1) {
            return 1;
        }
        return page;
    }
}
