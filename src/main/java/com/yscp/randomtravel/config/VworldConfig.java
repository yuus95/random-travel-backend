package com.yscp.randomtravel.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class VworldConfig {

    @Value("${vworld.key}")
    private String key;
}
