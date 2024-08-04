package com.yscp.randomtravel.utill;

import io.jsonwebtoken.Claims;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtUtilTest {

    private String testJwtKey;

    @BeforeEach
    void setUp() {
        testJwtKey = "2A8DCB2CCF8D46667B1BB6984ASDF231ASDFADSFASDFASDF23";
    }

    @DisplayName("키를 생성할 수 있다.")
    @Test
    void createJwt() {
        JwtUtil jwtUtil = new JwtUtil(testJwtKey);
        String token = jwtUtil.createToken("hello");
        assertNotNull(token);
    }

    @DisplayName("토큰을 복호화할 수 있다.")
    @Test
    void extractClaim() {
        String username = "KimParK";
        JwtUtil jwtUtil = new JwtUtil(testJwtKey);
        String token = jwtUtil.createToken(username);

        Assertions.assertThat(jwtUtil.extractClaim(token, Claims::getSubject ));

    }
}
