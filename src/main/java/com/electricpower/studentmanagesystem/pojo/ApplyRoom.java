package com.electricpower.studentmanagesystem.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApplyRoom {
    private int id;
    private String stuNum;
    private int fun;
}
