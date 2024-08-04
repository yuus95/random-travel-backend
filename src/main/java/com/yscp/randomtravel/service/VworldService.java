package com.yscp.randomtravel.service;

import com.yscp.randomtravel.config.VworldConfig;
import com.yscp.randomtravel.domain.entity.AdministrativeDistrict;
import com.yscp.randomtravel.domain.response.rest.SigunguResponseDto;
import com.yscp.randomtravel.domain.response.rest.VworldResponseDto;
import com.yscp.randomtravel.utill.HttpEntityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VworldService {
    private final RestTemplate restTemplate;
    private final VworldConfig vworldConfig;
    private final static String SIGUNGU_URI = "https://api.vworld.kr/ned/data/admSiList";

    public void getSiGungu() {
        List<SigunguResponseDto.AdmVo> result = new ArrayList<>();
        Arrays.stream(AdministrativeDistrict.values())
                .forEach(item -> {
                    URI uri = UriComponentsBuilder
                            .fromHttpUrl(SIGUNGU_URI)
                            .queryParam("admCode", item.getCode())
                            .queryParam("format", "JSON")
                            .queryParam("numOfRows", 1000)
                            .queryParam("key", vworldConfig.getKey())
                            .build()
                            .toUri();

                    ResponseEntity<VworldResponseDto> exchange = restTemplate.exchange(uri,
                            HttpMethod.GET,
                            HttpEntityFactory.createEmptyBody(),
                            VworldResponseDto.class);
                    VworldResponseDto body = exchange.getBody();
                    if (!CollectionUtils.isEmpty(body.getAdmVoList())) {
                        result.addAll(body.getAdmVoList());
                    }
                });
    }
}
