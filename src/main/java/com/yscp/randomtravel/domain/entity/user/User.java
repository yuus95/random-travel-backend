package com.yscp.randomtravel.domain.entity.user;

import com.yscp.randomtravel.domain.entity.type.UserAuthorization;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserAuthorization userAuthorization;

    @Builder
    public User(Long id, String email, String password, UserAuthorization userAuthorization) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userAuthorization = userAuthorization;
    }
}
