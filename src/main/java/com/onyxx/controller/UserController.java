package com.onyxx.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Validated
@RestController
public class UserController {

    @PostMapping(value = "/send-otp")
    public ResponseEntity<?> sendOtp(@Valid String sendOTPRequest) {
        memberService.sendOtp(sendOTPRequest);
        return ResponseEntity.ok("OTP sent successfully!");
    }
}
