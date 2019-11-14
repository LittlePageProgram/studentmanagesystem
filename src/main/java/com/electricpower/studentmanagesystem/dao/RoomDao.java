package com.electricpower.studentmanagesystem.dao;

import com.electricpower.studentmanagesystem.dbutils.DBUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 房间信息
 */
@Repository
public class RoomDao {
    /**
     * 增加房间信息
     * @param stuNum
     * @param buildingNum
     * @param roomNum
     */
    public void addRoomInfo(String stuNum, String buildingNum, String roomNum) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"insert room values(null,'"+buildingNum+"','"+roomNum+"','"+stuNum+"')");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }

    public void removeRoom(String stuNum) {
        Connection conn = DBUtils.getConnection();
        Statement stmt = DBUtils.getStatement(conn);
        DBUtils.execute(stmt,"delete from room where stuNum='"+stuNum+"'");
        DBUtils.releaseStatement(stmt);
        DBUtils.releaseConnection(conn);
    }

}
