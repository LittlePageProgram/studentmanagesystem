package com.electricpower.studentmanagesystem.controller.card;

import com.electricpower.studentmanagesystem.dao.StudentDao;
import com.electricpower.studentmanagesystem.pojo.Student;
import com.electricpower.studentmanagesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
@RequestMapping("stu")
public class Stu {

    @Autowired
    StudentService studentService;

    /**
     * 菜单页面
     * @param modelMap
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("menu")
    public String menu(ModelMap modelMap, HttpServletRequest httpServletRequest){
        Student stu = (Student) httpServletRequest.getSession().getAttribute("stuInfo");
        modelMap.addAttribute("stu",stu);
        return "stu/stuMain";
    }

    /**
     * 信息页面
     * @return
     */
    @RequestMapping("modifyInfo")
    public String modifyInfo(){
        return "/stu/modifyStuInfo";
    }

    /**
     * 修改处理
     * @param httpServletRequest
     * @param address
     * @param phone
     * @return
     */
    @RequestMapping("modifyProcess")
    public String modifyProcess(HttpServletRequest httpServletRequest,String address,String phone){
        Student student = (Student) httpServletRequest.getSession().getAttribute("stuInfo");
        studentService.modifyProcess(student,address,phone);
        return "stu/modifySuccess";
    }

    /**
     * 充值
     * @return
     */
    @RequestMapping("topUp")
    public String topUp(){
        return "stu/topUp";
    }

    /**
     * 充值处理
     * @return
     */
    @RequestMapping("topUpProcess")
    public String topUpProcess(int money,HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("stuInfo");
        studentService.topUpProcess(student,money);
        return  "stu/topUpSuccess";
    }

    /**
     * 宿舍申请
     * @return
     */
    @RequestMapping("apply")
    public String apply(HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("stuInfo");
        boolean isApply = studentService.applyRoom(student.getStuNum());
        if(isApply){
            return "stu/applySuccess";
        }else {
            return "stu/applying";
        }
    }

    @RequestMapping("remove")
    public String remove(HttpServletRequest httpServletRequest){
        Student student = (Student) httpServletRequest.getSession().getAttribute("stuInfo");
        boolean remove = studentService.remove(student.getStuNum());
        if(remove){
            return "stu/applySuccess";
        }else {
            return "stu/applying";
        }
    }
}
