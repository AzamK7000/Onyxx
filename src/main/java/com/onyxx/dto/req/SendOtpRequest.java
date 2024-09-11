package com.onyxx.dto.req;

import lombok.Data;

@Data
public class SendOtpRequest {
    private String username;
    private String password;
}
