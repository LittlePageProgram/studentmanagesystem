package com.electricpower.studentmanagesystem.controller.card;

import com.electricpower.studentmanagesystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 学生登录界面
     * @return
     */
    @RequestMapping("stu")
    public String stuLogin(){
        return "login/stuLogin";
    }

    /**
     * 登录处理类
     * @return
     */
    @RequestMapping("loginProcessorAdmin")
    public String loginProcessorAdmin(String name, String password, HttpServletRequest httpRequest){
        boolean login=loginService.loginAdmin(name,password);
        if(login){
            httpRequest.setAttribute("login","admin");
            return "login/status/loginSuccessAdmin";
        }else {
            return "login/status/loginFailedAdmin";
        }
    }

    @RequestMapping("loginProcessorStu")
    public String loginProcessorStu(String stuNum, String password, HttpServletRequest httpRequest){
        boolean login=loginService.loginStu(stuNum,password,httpRequest);
        if(login){
            httpRequest.setAttribute("login","stu");
            return "login/status/loginSuccessStu";
        }else {
            return "login/status/loginFailedStu";
        }
    }
}
