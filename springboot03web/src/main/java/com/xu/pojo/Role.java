package com.xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//权限表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer no;//权限对应数字
    private String identity;//身份
}
