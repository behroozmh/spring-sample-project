package com.behi.sec.service;

import com.behi.sec.model.UserModel;

public interface UserService {
    UserModel getUserByUsername(String username);
    UserModel getUserByMobile(String mobile);
}
