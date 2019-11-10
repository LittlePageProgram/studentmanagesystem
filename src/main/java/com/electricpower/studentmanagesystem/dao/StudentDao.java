package com.electricpower.studentmanagesystem.dao;

import com.electricpower.studentmanagesystem.dbutils.DBUtils;
import com.electricpower.studentmanagesystem.pojo.Student;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 学生信息处理类
 */
@Repository
public class StudentDao {
    /**
     * 增加学生
     * @param student
     */
    public void addStudent(Student student){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"insert student values (null,'"+
                student.getStuNum()+"','"+
                student.getSname()+"',"+
                student.getSage()+",'"+
                student.getBirthdate()+"','"+
                student.getIdentifyNum()+"','"+
                student.getAddress()+"','"+
                student.getPhone()+"',"+
                student.getCheck()+",'"+
                student.getClazz()+"','"+
                student.getPasswd()+"');");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }
}
