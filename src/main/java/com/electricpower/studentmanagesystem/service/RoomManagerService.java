package com.electricpower.studentmanagesystem.service;

import com.electricpower.studentmanagesystem.controller.card.RoomManager;
import com.electricpower.studentmanagesystem.dao.ApplyRoomDao;
import com.electricpower.studentmanagesystem.dao.RoomDao;
import com.electricpower.studentmanagesystem.dao.RoomManagerDao;
import com.electricpower.studentmanagesystem.pojo.ApplyRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 宿舍管理服务类
 */
@Service
public class RoomManagerService {

    @Autowired
    RoomManagerDao roomManagerDao;

    @Autowired
    RoomDao roomDao;

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
    public void addRoomProcessor(String stuNum, String buildingNum, String roomNum) {
        roomManagerDao.removeBystuNum(stuNum);
        roomDao.addRoomInfo(stuNum,buildingNum,roomNum);
    }
}
