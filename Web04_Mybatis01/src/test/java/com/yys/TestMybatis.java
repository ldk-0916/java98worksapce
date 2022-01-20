package com.yys;

import com.yys.dao.UserDao;
import com.yys.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 *
 * @Author: 夜遊神
 * @Date: 2022/01/17/13:40
 */
public class TestMybatis {
    private UserDao mapper;
    private SqlSession openSession;
    private InputStream is;
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        is = Resources.getResourceAsStream(resource);
        //return new SqlSessionFactoryBuilder().build(is);
        return new SqlSessionFactoryBuilder().build(is);
    }
    //

    /**
     *  Dao-->DaoImpl
     *  Dao-->Dao.xml
     * SqlSession代表和数据库的一次会话,用完必须关闭
     * SqlSession和Connection都是线程非安全的,每一次都应该获取新的对象
     * getMapper():mapper没有实现类,mybatis会为这个接口生成一个动态代理对象(将接口和xml绑定)
     * UserDao mapper = openSession.getMapper(UserDao.class);
     *
     * sqlSessionFactory:根据xml配置文件(全局配置文件)获取到一个sqlSessionFactory对象,包含了一些数据源和运行环境信息
     * sql映射文件:配置了每一个sql,以及封装规则等
     * 使用sql唯一标识来告诉mybatis去执行哪个sql语句,sql都是保存在sql映射文件中的
     * @throws IOException
     */
    @Before
    public void test01() throws IOException {
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //获取SqlSession对象
         openSession = sqlSessionFactory.openSession();
        //获取接口实现类代理对象
            //获取接口的实现类对象
            //会为接口生成一个代理对象,执行增删改查的..
            mapper = openSession.getMapper(UserDao.class);
            List<User> userList = mapper.findAll();
            for (User users : userList) {
                System.out.println(users);
            }

    }


    @Test
    public void addUser(){
        User user = new User(null,"法外狂徒张三","男",new Date(),"上海");
        int i = mapper.addUser(user);
        System.out.println(user.getUid());
    }

    @Test
    public void searchById(){
        System.out.println(mapper.searchById(1));
    }
    @Test
    public void updateUser(){
        //System.out.println(mapper.updateUser(new User(1,"张三","男",new Date(),"苏州")));
        User user = new User(1,"张三","男",new Date(),"苏州");
        mapper.updateUser(user);
    }

    @Test
    public void deleteById(){
        System.out.println(mapper.deleteByid(10));
    }

    @Test
    public void searchByUsername(){
        System.out.println(mapper.searchByUsername("张"));

    }
    @After
    public void destory() throws IOException {
        //提交事务
        openSession.commit();

        //4. 关闭资源
        openSession.close();
        is.close();
    }
}
