package com.electricpower.studentmanagesystem.service;

import com.electricpower.studentmanagesystem.dao.StudentDao;
import com.electricpower.studentmanagesystem.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public ArrayList<Student> getAll(){
        return studentDao.getAll();
    }

    public boolean removeStu(String stuNum) {
        Student stu = studentDao.getStuByStuNum(stuNum);
        if(stu==null){
            return false;
        }
        studentDao.setCheckZero(stuNum);
        return true;
    }

    public void modifyProcess(Student student, String address, String phone) {
        student.setAddress(address);
        student.setPhone(phone);
        studentDao.updateStudent(student.getStuNum(),address,phone);
    }

    public void topUpProcess(Student student, int money) {
        student.setBalance(student.getBalance()+money);
        studentDao.updateStudent(student.getStuNum(),student.getBalance());
    }
}
