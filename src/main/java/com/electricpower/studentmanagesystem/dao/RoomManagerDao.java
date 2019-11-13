package com.electricpower.studentmanagesystem.dao;

import com.electricpower.studentmanagesystem.controller.card.RoomManager;
import com.electricpower.studentmanagesystem.dbutils.DBUtils;
import com.electricpower.studentmanagesystem.pojo.ApplyRoom;
import com.electricpower.studentmanagesystem.pojo.Student;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class RoomManagerDao {
    public ArrayList<ApplyRoom> getAll() {
        ArrayList<ApplyRoom> arrayList=new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            Statement stmt = DBUtils.getStatement(conn);
            ResultSet rs = DBUtils.executeQuery(stmt, "select * from applyRoom where id > 1");
            while (rs.next()) {
                ApplyRoom applyRoom=new ApplyRoom();
                applyRoom.setId(rs.getInt(1)).setStuNum(rs.getString(2)).setFun(rs.getInt(3));
                arrayList.add(applyRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /**
     * 删除用户请求
     * @param stuNum
     */
    public void removeBystuNum(String stuNum) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"delete from applyRoom where stuNum='"+stuNum+"'");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }



}
