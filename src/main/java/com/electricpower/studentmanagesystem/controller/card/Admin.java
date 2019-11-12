package com.electricpower.studentmanagesystem.controller.card;

import com.electricpower.studentmanagesystem.pojo.Student;
import com.electricpower.studentmanagesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

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
    public String menu(ModelMap modelMap){
        ArrayList<Student> stu = studentService.getAll();
        modelMap.put("stuinfo",stu);
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
        studentService.addStudent(student);
        return "admin/stuManager/addStuSuccess";
    }

    /**
     * 注销学生页面
     * @return
     */
    @RequestMapping("removeStu")
    public String removeStu(){
        return "admin/stuManager/removeStu";
    }

    /**
     * 注销学生处理
     * @return
     */
    @RequestMapping("removeStuProcessor")
    public String removeStuProcess(String stuNum){
        if(studentService.removeStu(stuNum)){
            return "admin/stuManager/removeStuSuccess";
        }else {
            return "admin/stuManager/removeStuFailed";
        }
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
