package com.yys.dao;

import com.yys.pojo.User;

import java.util.List;

/**
 * @Author: 夜遊神
 * @Date: 2022/01/17/10:42
 */
public interface UserDao {
    /**
     * 查询所有数据
     * @return
     */
    List<User> findAll();
}
