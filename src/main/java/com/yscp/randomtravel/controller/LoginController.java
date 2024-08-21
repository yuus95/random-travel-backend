package com.yscp.randomtravel.controller;

import com.yscp.randomtravel.domain.request.login.LoginRequestDto;
import com.yscp.randomtravel.domain.request.login.signup.SignupRequestDto;
import com.yscp.randomtravel.service.UserService;
import com.yscp.randomtravel.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/random-travel")
@RestController
public class LoginController {
    private final AuthService authService;
    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignupRequestDto signupRequestDto) {
        userService.saveUser(signupRequestDto);
        return ResponseEntity.ok().build();
    }
}
