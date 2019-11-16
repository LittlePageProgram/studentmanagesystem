package com.electricpower.studentmanagesystem.service;

import com.electricpower.studentmanagesystem.controller.card.RoomManager;
import com.electricpower.studentmanagesystem.dao.ApplyRoomDao;
import com.electricpower.studentmanagesystem.dao.RoomDao;
import com.electricpower.studentmanagesystem.dao.RoomManagerDao;
import com.electricpower.studentmanagesystem.dao.StudentDao;
import com.electricpower.studentmanagesystem.pojo.ApplyRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 宿舍管理服务类
 */
@Service
public class RoomManagerService {

    @Autowired
    RoomManagerDao roomManagerDao;

    @Autowired
    RoomDao roomDao;

    @Autowired
    StudentDao studentDao;

    /**
     * 获取所有房间
     * @return
     */
    public ArrayList<ApplyRoom> getAll() {
        return roomManagerDao.getAll();
    }

    /***
     * 拒绝请求
     * @param stuNum
     */
    public void removeCancel(String stuNum) {
        roomManagerDao.removeBystuNum(stuNum);
    }

    /**
     * 房间处理服务
     * @param stuNum
     * @param buildingNum
     * @param roomNum
     */
    public void addRoomProcessor( String stuNum, String buildingNum, String roomNum,String password) {
        roomManagerDao.removeBystuNum(stuNum);
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH);
        int day = ca.get(Calendar.DAY_OF_MONTH);
        roomDao.addRoomInfo(stuNum,buildingNum,roomNum,year+"-"+month+"-"+day,password);
        studentDao.updateRoomStatus( stuNum);
    }

    /**
     * 移除房间
     * @param stuNum
     */
    public void removeRoom(String stuNum) {
        roomManagerDao.removeBystuNum(stuNum);
        roomDao.removeRoom(stuNum);
        studentDao.updateRoomStatusNon(stuNum);
    }
}
