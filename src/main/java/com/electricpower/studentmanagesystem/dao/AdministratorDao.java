package com.electricpower.studentmanagesystem.dao;

import com.electricpower.studentmanagesystem.dbutils.DBUtils;
import com.electricpower.studentmanagesystem.pojo.Administrator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * AdministratorDao数据源
 */
@Repository
public class AdministratorDao {

    public Administrator getAdminByName(String name){
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        ResultSet rs = null;
        Administrator admin = new Administrator();
        try {
            rs=stmt.executeQuery("select * from administrator where aname = '"+name +"'");
            while (rs.next()){
                admin.setPasswd(rs.getString("passwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
