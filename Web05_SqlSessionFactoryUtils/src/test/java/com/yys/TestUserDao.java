package com.yys;

import com.yys.dao.UserDao;
import com.yys.pojo.QueryVo;
import com.yys.pojo.User;
import com.yys.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 夜遊神
 * @Date: 2022/01/18/15:32
 */
public class TestUserDao {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("uid",1);
        map.put("username","张无忌");
        map.put("sex","男");
        map.put("birthday",new Date());
        map.put("address","南京");
        mapper.updateUser(map);
        //提交事务并关闭
        SqlSessionFactoryUtil.commit(sqlSession);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setSex("男");
        user.setAddress("南京");
        QueryVo queryVo = new QueryVo(1l,5,user);
        List<User> userList = mapper.searchByCondition(queryVo);
        for (User user1:userList) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtil.commit(sqlSession);
    }
}
