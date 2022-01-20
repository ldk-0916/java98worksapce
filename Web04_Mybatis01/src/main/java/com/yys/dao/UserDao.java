package com.yys.dao;

import com.yys.pojo.User;

import java.util.List;

/**
 * @Author: 夜遊神
 * @Date: 2022/01/17/10:42
 */
public interface UserDao {
    /**
     * 增加
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     *根据id查询
     * @param id
     * @return
     */
    User searchById(Integer id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户,通过id删除
     * @return
     */
    int deleteByid(Integer id);

    /**
     * 通过用户名模糊查询
     * @param username
     * @return
     */
    List<User> searchByUsername(String username);
    /**
     * 查询所有数据
     * @return
     */
    List<User> findAll();
}
