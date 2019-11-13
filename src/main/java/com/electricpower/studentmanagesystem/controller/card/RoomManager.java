package com.electricpower.studentmanagesystem.controller.card;

import com.electricpower.studentmanagesystem.pojo.ApplyRoom;
import com.electricpower.studentmanagesystem.service.RoomManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("roomManager")
public class RoomManager {

    @Autowired
    RoomManagerService roomManagerService;

    /**
     * 宿舍管理菜单
     * @param modelMap
     * @return
     */
    @RequestMapping("roomMain")
    public String roomMain(ModelMap modelMap){
        ArrayList<ApplyRoom> applyRooms = roomManagerService.getAll();
        modelMap.addAttribute("applyRooms",applyRooms);
        applyRooms.forEach((x)->{
            System.out.println(x);
        });
        return "admin/roomManager/roomMain";
    }

    /**
     * 拒绝宿舍分配请求
     * @param stuNum
     * @return
     */
    @RequestMapping("roomCancel")
    @ResponseBody
    public String roomCancel(String stuNum){
        roomManagerService.removeCancel(stuNum);
        return "removeSuccess";
    }

    @RequestMapping("roomAccept")
    public String roomAccept(String stuNum, int fun, HttpServletRequest httpServletRequest){
        if(fun==0){
            //增加宿舍条目
            httpServletRequest.getSession().setAttribute("addRoomStuNum",stuNum);
            return "admin/roomManager/addRoomInfo";
        }else{
            //删除stuNum
            return "删除成功";
        }
    }

    @RequestMapping("addRoomProcessor")
    @ResponseBody
    public String addRoomProcessor(String buildingNum,String roomNum, HttpServletRequest httpServletRequest){
        String stuNum = httpServletRequest.getSession().getAttribute("addRoomStuNum").toString();

        System.out.println(stuNum);
        System.out.println(buildingNum);
        System.out.println(roomNum);

        roomManagerService.addRoomProcessor(stuNum,buildingNum,roomNum);
        return "";
    }
}
