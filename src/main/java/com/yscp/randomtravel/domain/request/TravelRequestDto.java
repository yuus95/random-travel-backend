package com.yscp.randomtravel.domain.request;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class TravelRequestDto {
    private final List<Integer> ids;

    public TravelRequestDto(List<Integer> ids) {
        this.ids = ids;
    }
}
