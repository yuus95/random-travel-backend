package com.yscp.randomtravel.utill;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class HttpEntityFactory {

    public static HttpEntity<String> createEmptyBody() {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new HttpEntity<>(httpHeaders);
    }
}
