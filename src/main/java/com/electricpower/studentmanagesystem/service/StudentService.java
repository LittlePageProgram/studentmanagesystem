package com.electricpower.studentmanagesystem.service;

import com.electricpower.studentmanagesystem.dao.StudentDao;
import com.electricpower.studentmanagesystem.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
}
