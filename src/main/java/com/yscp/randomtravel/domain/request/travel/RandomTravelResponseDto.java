package com.yscp.randomtravel.domain.request.travel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class RandomTravelResponseDto {
    private final List<RandomTravelItemResponse> travels;
}
