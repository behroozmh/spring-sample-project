package com.behi.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin() {
        return "login";
    }


    @RequestMapping(value = "/lwm", method = RequestMethod.GET)
    public String getLoginWithMobile(ModelMap model) {
        return "loginWithMobile";
    }

    @RequestMapping(value = "/lwm", method = RequestMethod.POST)
    public String postLoginWithMobile(ModelMap model) {
        return "loginWithMobile";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Object getUser(Principal principal) {
        return principal;
    }

}
