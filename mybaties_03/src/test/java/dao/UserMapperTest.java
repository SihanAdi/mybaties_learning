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
    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void getUserById(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }
    @Test
    public void testLog4j(){
        logger.info("info: log4j");
        logger.debug("debug: log4j");
        logger.error("error: log4j");
    }
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startId",0);
        map.put("pageSize",2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }


        sqlSession.close();
    }


}
