package com.yscp.randomtravel.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Getter
public enum AdministrativeDistrict {
    SEOUL("서울", "11"),
    BUSAN("부산", "26"),
    DEAGU("대구", "27"),
    INCHOEN("인천", "28"),
    GWANGJU("광주", "29"),
    DAEJEON("대전", "30"),
    ULSAN("울산", "31"),
    SEJONG("세종", "36"),
    GYEONGGI("경기도", "41"),
    GANGWON("강원특별자치도", "51"),
    NORTH_CHUNGCHEONG("충청북도", "43"),
    SOUTH_CHUNGCHEONG("충청남도", "44"),
    NOTH_JEOLLA("전라특별자치도", "52"),
    SOUTH_JEOLLA("전라남도", "46"),
    JEJU("제주특별자치도", "52"),

    ;

    private final String description;
    private final String code;
}
