package com.electricpower.studentmanagesystem.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 管理员类
 */
@Data
@Accessors(chain = true)
public class Administrator {
    private int aid;
    private String aname;
    private int aage;
    private String identifyNum;
    private String passwd;
}
