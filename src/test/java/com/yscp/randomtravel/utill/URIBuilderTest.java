package com.yscp.randomtravel.utill;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;

class URIBuilderTest {
    @DisplayName("URI Param를 넣고 생성할 수 있다.")
    @Test
    void createWithParams() throws URISyntaxException {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("param1", "param1");
        multiValueMap.add("param2", "param2");

        Assertions.assertThat(URIBuilder.createeURIWithParams("http://test.com", multiValueMap))
                .isEqualTo(new URI("http://test.com?param1=param1&param2=param2"));
    }

    @DisplayName("URI를 생성할 수 있다.")
    @Test
    void create() throws URISyntaxException {
        Assertions.assertThat(URIBuilder.createeURIWithParams("Http://naver.com", null))
                .isEqualTo(new URI("Http://naver.com"));
    }

    @DisplayName("URI가 빈값이라면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void throwExceptionWhenUriValueNull(String uri) {
        Assertions.assertThatThrownBy(() -> URIBuilder.createeURIWithParams(uri, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
