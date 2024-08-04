package com.yscp.randomtravel.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RequiredArgsConstructor
@Service
@Slf4j
public class VwolrdRestTemplate {
    private final RestTemplate restTemplate;

    public <T> T exchange(URI uri, HttpMethod httpMethod, HttpEntity httpEntity, Class<T> responseType) {
        try {
            ResponseEntity<T> exchange = restTemplate.exchange(uri,
                    httpMethod,
                    httpEntity,
                    responseType);

            if (!exchange.getStatusCode().is2xxSuccessful()) {
                throw new InternalException("Sever Error");
            }

            return exchange.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
