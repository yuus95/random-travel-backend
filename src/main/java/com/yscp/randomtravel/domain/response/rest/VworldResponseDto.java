package com.yscp.randomtravel.domain.response.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class VworldResponseDto {
    private SigunguResponseDto admVoList;

    @JsonCreator
    public VworldResponseDto(@JsonProperty("admVOList") SigunguResponseDto admVoList) {
        this.admVoList = admVoList;
    }

    public List<SigunguResponseDto.AdmVo> getAdmVoList() {
        if (this.admVoList == null) {
            return  new ArrayList<>();
        }
        return this.admVoList.getAdmVoList();
    }
}
