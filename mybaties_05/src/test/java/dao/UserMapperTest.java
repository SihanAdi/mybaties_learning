package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.User;
import utils.mybatiesUtile;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
//    日志对象，参数为当前类的class
//    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void test(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }

//        User userById = mapper.getUserById(1);
//        System.out.println(userById);
        int adns = mapper.insertUser(new User(5, "adns", "123123"));
        sqlSession.close();
    }



}
