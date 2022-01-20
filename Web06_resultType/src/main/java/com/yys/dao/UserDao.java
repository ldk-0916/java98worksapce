package com.yys.dao;

import com.yys.pojo.User;
import com.yys.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 夜遊神
 * @Date: 2022/01/19/9:21
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 根据address查询用户,如果没有传入地址则查询出所有用户
     * @param address
     * @return
     */
    List<User> findUserListByAddress(@Param("address") String address);

    /**
     * 根据用户的地址和性别查询用户, 如果有address才考虑address的条件，如果有sex才考虑sex的条件
     * @param user
     * @return
     */
    List<User> findUserListByAddressAndSex(User user);

    void deleteById(List<Integer> ids);
}
