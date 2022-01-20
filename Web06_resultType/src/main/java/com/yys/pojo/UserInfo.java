package com.yys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: 夜遊神
 * @Date: 2022/01/19/9:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private Integer userId;
    private String username;
    private String userSex;
    private String userBirthday;
    private String userAddress;
}
