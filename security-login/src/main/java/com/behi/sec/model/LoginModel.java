package com.behi.sec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
    @NotEmpty(message = "invalid.username")
    private String username;
    @NotEmpty(message = "invalid.password")
    private String password;
    private String captcha;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
