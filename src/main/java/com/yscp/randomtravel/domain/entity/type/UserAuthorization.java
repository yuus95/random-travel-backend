package com.yscp.randomtravel.domain.entity.type;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthorization implements GrantedAuthority {
    BASIC,
    ;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
