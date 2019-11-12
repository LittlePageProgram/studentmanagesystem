package com.electricpower.studentmanagesystem.service;

import com.electricpower.studentmanagesystem.dao.AdministratorDao;
import com.electricpower.studentmanagesystem.dao.StudentDao;
import com.electricpower.studentmanagesystem.pojo.Administrator;
import com.electricpower.studentmanagesystem.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {

    @Autowired
    AdministratorDao administratorDao;

    @Autowired
    StudentDao studentDao;

    public boolean loginAdmin(String name, String password) {
        Administrator admin = administratorDao.getAdminByName(name);
        if(admin.getPasswd()==null) {
            return false;
        }else if(admin.getPasswd().equals(password)){
            return true;
        }else {
            return false;
        }
    }

    public boolean loginStu(String stuNum, String password, HttpServletRequest httpRequest) {
        Student student= studentDao.getStuByStuNum(stuNum);
        if(student==null||student.getPasswd()==null) {
            return false;
        }else if(student.getPasswd().equals(password)){
            httpRequest.getSession().setAttribute("stuInfo",student);
            return true;
        }else {
            return false;
        }
    }
}
