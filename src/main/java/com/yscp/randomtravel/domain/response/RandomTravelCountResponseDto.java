package com.yscp.randomtravel.domain.response;

import lombok.Getter;

@Getter
public class RandomTravelCountResponseDto {
    private final Integer count;


    public RandomTravelCountResponseDto(Integer count) {
        this.count = count;
    }
}
