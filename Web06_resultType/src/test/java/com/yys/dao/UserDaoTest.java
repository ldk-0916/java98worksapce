package com.yys.dao;

import com.yys.pojo.User;
import com.yys.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 夜遊神
 * @Date: 2022/01/19/9:39
 */
public class UserDaoTest {
    @Test
    public void findAll(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.findAll());
        SqlSessionFactoryUtil.commit(sqlSession);
    }
    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.findUserListByAddress("南京"));
        SqlSessionFactoryUtil.commit(sqlSession);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userListByAddressAndSex = mapper.findUserListByAddressAndSex(new User());
        for (User listByAddressAndSex : userListByAddressAndSex) {
            System.out.println(listByAddressAndSex);
        }
        SqlSessionFactoryUtil.commit(sqlSession);
    }

    @Test
    public void deleteById(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List list = new ArrayList();
        list.add(6);
        list.add(8);
        list.add(9);
        mapper.deleteById(list);
        SqlSessionFactoryUtil.commit(sqlSession);
    }
}
