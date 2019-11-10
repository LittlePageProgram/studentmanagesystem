package com.electricpower.studentmanagesystem.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 学生类
 */
@Data
@Accessors(chain = true)
public class Student {
    private int sid;
    private String stuNum;
    private String sname;
    private int sage;
    private String birthdate;
    private String identifyNum;
    private String address;
    private String phone;
    private String clazz;
    private String passwd;
    private int check;
}
