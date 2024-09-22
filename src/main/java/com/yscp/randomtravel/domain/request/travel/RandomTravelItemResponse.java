package com.yscp.randomtravel.domain.request.travel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class RandomTravelItemResponse {
    private final String name;
    private final String location;
}
