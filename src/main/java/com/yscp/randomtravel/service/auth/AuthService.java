package com.yscp.randomtravel.service.auth;

import com.yscp.randomtravel.domain.request.login.LoginRequestDto;
import com.yscp.randomtravel.service.UserService;
import com.yscp.randomtravel.utill.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    public String login(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(loginRequestDto.getEmail());
        return jwtUtil.createToken(userDetails.getUsername());
    }
}
