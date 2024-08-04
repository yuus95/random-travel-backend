package com.yscp.randomtravel.service;

import com.yscp.randomtravel.config.VworldConfig;
import com.yscp.randomtravel.domain.entity.AdministrativeDistrict;
import com.yscp.randomtravel.domain.response.rest.SigunguResponseDto;
import com.yscp.randomtravel.domain.response.rest.VworldResponseDto;
import com.yscp.randomtravel.utill.HttpEntityFactory;
import com.yscp.randomtravel.utill.URIBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VworldService {
    private final VwolrdRestTemplate restTemplate;
    private final VworldConfig vworldConfig;

    public void getSiGungu() {
        List<SigunguResponseDto.AdmVo> result = new ArrayList<>();
        Arrays.stream(AdministrativeDistrict.values())
                .forEach(item -> {

                    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                    params.add("admCode", item.getCode());
                    params.add("format", "JSON");
                    params.add("numOfRows", "1000");
                    params.add("key", vworldConfig.getKey());

                    URI uri = URIBuilder.createeURIWithParams(vworldConfig.getSigunguUri(), params);

                    VworldResponseDto vworldResponseDto = restTemplate.exchange(
                            uri,
                            HttpMethod.GET,
                            HttpEntityFactory.createEmptyBody(),
                            VworldResponseDto.class);

                    if (vworldResponseDto != null && !CollectionUtils.isEmpty(vworldResponseDto.getAdmVoList())) {
                        result.addAll(vworldResponseDto.getAdmVoList());
                    }
                });

    }
}
