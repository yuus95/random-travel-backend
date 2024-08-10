package com.yscp.randomtravel.domain.request.login.signup;

import com.yscp.randomtravel.domain.entity.type.UserAuthorization;
import com.yscp.randomtravel.domain.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@Getter
public class SignupRequestDto {
    private String email;
    private String password;

    public SignupRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(this.email)
                .password(passwordEncoder.encode(password))
                .userAuthorization(UserAuthorization.BASIC)
                .build();
    }
}
