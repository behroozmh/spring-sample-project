package com.behi.sec.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * create User: behrooz.mh
 * Date: 12/28/2022
 * TIME: 12:57 PM
 **/
@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(HttpServletRequest servletRequest) {
        return "home";
    }
}
