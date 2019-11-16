package com.electricpower.studentmanagesystem.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Room {
    private int rid;
    private String buildingNum;
    private String roomNum;
    private String stuNum;
    private String enterTime;
    private String enterPassword;
}
