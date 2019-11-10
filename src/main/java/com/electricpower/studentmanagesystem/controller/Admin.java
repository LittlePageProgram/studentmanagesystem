package com.electricpower.studentmanagesystem.controller;

import com.electricpower.studentmanagesystem.pojo.Student;
import com.electricpower.studentmanagesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 管理员服务
 */
@Controller
@RequestMapping("admin")
public class Admin {

    @Autowired
    StudentService studentService;

    /**
     * 菜单界面
     * @return
     */
    @RequestMapping("menu")
    public String menu(){
        return "admin/adminMain";
    }

    /**
     * 增加学生界面
     * @return
     */
    @RequestMapping("addStu")
    public String addStu(){
        return "admin/stuManager/addStu";
    }

    /**
     * 增加学生的处理
     * @param student
     * @return
     */
    @RequestMapping("addStuProcessor")
    public String addStuProcessor(Student student){
        //check的1为已核实
        student.setPasswd(student.getStuNum()).setCheck(1);
        System.out.println(student);
        studentService.addStudent(student);
        return "admin/stuManager/addStuSuccess";
    }

    /**
     * 修改信息界面
     * @return
     */
    @RequestMapping("modifyStuInfo")
    public String modifyStuInfo(){
        return "admin/modifyStuInfo";
    }


}
