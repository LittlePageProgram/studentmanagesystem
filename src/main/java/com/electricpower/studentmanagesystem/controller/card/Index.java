package com.electricpower.studentmanagesystem.controller.card;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class Index {
    @RequestMapping("")
    public String index(){
        return "login/index";
    }
}
