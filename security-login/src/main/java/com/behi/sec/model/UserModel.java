package com.behi.sec.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Integer id;
    private String uuid;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String mobile;
    private Boolean isEnabled;
    private Boolean isLocked;
    private Boolean isExpired;
    private Boolean isCredentials;

}
