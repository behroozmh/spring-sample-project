package com.behi.sec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginWithMobileModel {
    @NotEmpty(message = "invalid.mobile")
    private String mobile;
    @NotEmpty(message = "invalid.code")
    private String code;
    private String captcha;

    public LoginWithMobileModel(String mobile, String code) {
        this.mobile = mobile;
        this.code = code;
    }
}
