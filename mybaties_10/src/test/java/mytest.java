import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.mybatiesUtile;

public class mytest {
    @Test
    public void test(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("======================================================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        SqlSession sqlSession2 = mybatiesUtile.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();
        System.out.println("======================================================");
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);
        sqlSession2.close();


    }
}

