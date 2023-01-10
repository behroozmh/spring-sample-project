package com.behi.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(){
        return "profile/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postIndex(){
        return "profile/index";
    }

    @RequestMapping(value = "/changepass",method = RequestMethod.GET)
    public String getHome(){
        return "profile/changepass";
    }

    @RequestMapping(value = "/changepass",method = RequestMethod.POST)
    public String postHome(){
        return "profile/changepass";
    }
}
