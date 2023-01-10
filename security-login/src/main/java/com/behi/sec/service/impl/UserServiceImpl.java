package com.behi.sec.service.impl;

import com.behi.sec.dao.UserDAO;
import com.behi.sec.mapper.UserMapper;
import com.behi.sec.model.UserModel;
import com.behi.sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel getUserByUsername(String username) {
        return userMapper.ConvertToModel( userDAO.findByUsername(username));
    }

    @Override
    public UserModel getUserByMobile(String mobile) {
        return userMapper.ConvertToModel( userDAO.findByMobile(mobile));
    }
}
