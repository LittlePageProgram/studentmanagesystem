package com.electricpower.studentmanagesystem.dao;

import com.electricpower.studentmanagesystem.controller.card.Stu;
import com.electricpower.studentmanagesystem.dbutils.DBUtils;
import com.electricpower.studentmanagesystem.pojo.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

/**
 * 学生信息处理类
 */
@Repository
public class StudentDao {
    /**
     * 增加学生
     *
     * @param student
     */
    public void addStudent(Student student) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt, "insert student values (null,'" +
                student.getStuNum() + "','" +
                student.getSname() + "'," +
                student.getSage() + ",'" +
                student.getBirthdate() + "','" +
                student.getIdentifyNum() + "','" +
                student.getAddress() + "','" +
                student.getPhone() + "'," +
                student.getCheck() + ",'" +
                student.getClazz() + "','" +
                student.getPasswd() + "',0,0);");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }

    /**
     * 获取所有
     *
     * @return
     */
    public ArrayList<Student> getAll() {
        ArrayList<Student> arr = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            Statement stmt = DBUtils.getStatement(conn);
            ResultSet rs = DBUtils.executeQuery(stmt, "select * from student");
            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt(1)).setStuNum(rs.getString(2)).
                        setSname(rs.getString(3)).setSage(rs.getString(4)).
                        setBirthdate(rs.getString(5)).setIdentifyNum(rs.getString(6)).
                        setAddress(rs.getString(7)).setPhone(rs.getString(8)).
                        setCheck(rs.getInt(9)).setClazz(rs.getString(10)).
                        setPasswd(rs.getString(11));
                arr.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * 查找一个学生
     *
     * @param stuNum
     * @return
     */
    public Student getStuByStuNum(String stuNum) {
        Student s = new Student();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stmt = DBUtils.getStatement(conn);
            rs = DBUtils.executeQuery(stmt, "SELECT * FROM `student` where stuNum ='" + stuNum + "'");
            while (rs.next()) {
                s.setSid(rs.getInt(1)).setStuNum(rs.getString(2)).
                        setSname(rs.getString(3)).setSage(rs.getString(4)).
                        setBirthdate(rs.getString(5)).setIdentifyNum(rs.getString(6)).
                        setAddress(rs.getString(7)).setPhone(rs.getString(8)).
                        setCheck(rs.getInt(9)).setClazz(rs.getString(10)).
                        setPasswd(rs.getString(11)).setBalance(rs.getDouble(12)).
                        setRoomId(rs.getInt(13));
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.releaseStatement(stmt);
            DBUtils.releaseConnection(conn);
        }
        return null;
    }

    /**
     * 注销置0
     *
     * @param stuNum
     */
    public void setCheckZero(String stuNum) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt, "update student set `check`=0 where stuNum='" + stuNum + "'");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }

    public void updateStudent(String stuNum, String address, String phone){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"update student set address='"+address+"',phone='"+phone+"' where stuNum='"+stuNum+"'");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }

    public void updateStudent(String stuNum, double balance) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"update student set balance="+balance+" where stuNum='"+stuNum+"'");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }
}
