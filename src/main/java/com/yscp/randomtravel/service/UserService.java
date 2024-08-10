package com.yscp.randomtravel.service;

import com.yscp.randomtravel.domain.entity.user.CustomUserDetail;
import com.yscp.randomtravel.domain.entity.user.User;
import com.yscp.randomtravel.domain.request.login.signup.SignupRequestDto;
import com.yscp.randomtravel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);

        if (userOptional.isEmpty()) {
            throw new IllegalAccessError("Not Found User");
        }

        return new CustomUserDetail(userOptional.get());
    }

    public void saveUser(SignupRequestDto signupRequestDto) {
        userRepository.save(signupRequestDto.toEntity(passwordEncoder));
    }
}
