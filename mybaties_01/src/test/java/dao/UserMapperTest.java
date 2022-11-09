package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.mybatiesUtile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
        //1.获得SqlSession对象
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        //执行sql
        //方式一：主要是用这种方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUser();

        //方式2
//        List<User> user = sqlSession.selectList("dao.UserDao.getUser");


        for (User user1 : user) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }
    @Test
    public void getUserLike(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userLike = mapper.getUserLike("%ad%");
        for (User user1 : userLike) {
            System.out.println(user1);
        }

        sqlSession.close();
    }
    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ns = mapper.addUser(new User(4, "ns", "1233334"));
        System.out.println(ns);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void addUser2(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", 4);
        map.put("UN", "ns");
        map.put("password","1231231");
        int ns = mapper.addUser2(map);
        System.out.println(ns);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int sn = mapper.updateUser(new User(4, "sn", "123123"));
        System.out.println(sn);
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int sn = mapper.deleteUser("sn");
        System.out.println(sn);
        sqlSession.commit();

        sqlSession.close();
    }
}
