package com.yscp.randomtravel.utill;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class URIBuilder {

    public static URI createeURIWithParams(String uri, MultiValueMap<String, String> params, String... path) {
        return UriComponentsBuilder
                .fromHttpUrl(uri)
                .queryParams(params)
                .buildAndExpand((Object) path)
                .toUri();
    }

    public static URI createeURI(String uri, String... path) {
        return UriComponentsBuilder
                .fromHttpUrl(uri)
                .buildAndExpand((Object) path)
                .toUri();
    }
}
