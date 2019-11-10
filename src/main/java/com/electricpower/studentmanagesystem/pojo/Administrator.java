package com.electricpower.studentmanagesystem.pojo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import lombok.ToString;
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
