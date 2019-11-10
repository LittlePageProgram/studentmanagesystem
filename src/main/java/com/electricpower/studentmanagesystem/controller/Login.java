package com.electricpower.studentmanagesystem.controller;

import com.electricpower.studentmanagesystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class Login {

    @Autowired
    LoginService loginService;

    /**
     * admin菜单界面
     * @return
     */
    @RequestMapping("admin")
    public String adminLogin(){
        return "login/adminLogin";
    }

    /**
     * 登录处理类
     * @return
     */
    @RequestMapping("loginProcessor")
    public String loginProcessor(String name, String password, HttpServletRequest httpRequest){
        boolean login=loginService.loginAdmin(name,password);
        if(login){
            httpRequest.setAttribute("login","true");
            return "login/status/loginSuccess";
        }else {
            return "login/status/loginFailed";
        }
    }
}
