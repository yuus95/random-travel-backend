package com.yscp.randomtravel.domain.response.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

//admVOList
@Getter
public class SigunguResponseDto {
    private final Integer numOfRows;
    private final Integer pageNo;
    private final Integer totalCount;
    private final List<AdmVo> admVoList;

    @JsonCreator
    public SigunguResponseDto(
            @JsonProperty("numOfRows") Integer numOfRows,
            @JsonProperty("pageNo") Integer pageNo,
            @JsonProperty("totalCount") Integer totalCount,
            @JsonProperty("admVOList") List<AdmVo> admVoList) {
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
        this.admVoList = admVoList;
    }

    @Getter
    public static class AdmVo {
        private final String admCodeNm;
        private final String admCode;
        private final String lowestAdmCodeNm;

        @JsonCreator
        public AdmVo(
                @JsonProperty("admCodeNm") String admCodeNm,
                @JsonProperty("admCode") String admCode,
                @JsonProperty("lowestAdmCodeNm") String lowestAdmCodeNm) {
            this.admCodeNm = admCodeNm;
            this.admCode = admCode;
            this.lowestAdmCodeNm = lowestAdmCodeNm;
        }
    }
}
