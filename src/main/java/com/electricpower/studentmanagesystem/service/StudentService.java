package com.electricpower.studentmanagesystem.service;

import com.electricpower.studentmanagesystem.controller.card.Stu;
import com.electricpower.studentmanagesystem.dao.ApplyRoomDao;
import com.electricpower.studentmanagesystem.dao.StudentDao;
import com.electricpower.studentmanagesystem.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 学生服务
 */
@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    ApplyRoomDao applyRoomDao;

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
        /**
         * 有欠款无法注销
         */
        if(stu.getBalance()<0){
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

    public boolean applyRoom(String stuNum) {
        if(applyRoomDao.getApplyRoombyStuNum(stuNum)!=null){
            return false;
        }else {
            applyRoomDao.addStudent(stuNum);
            return true;
        }
    }

    public boolean remove(String stuNum) {
        if(applyRoomDao.getApplyRoombyStuNum(stuNum)!=null){
            return false;
        }else {
            applyRoomDao.addRemove(stuNum);
            return true;
        }
    }

    public Student search(String stuNum) {
        Student stu = studentDao.getStuByStuNum(stuNum);
        return stu;
    }
}
