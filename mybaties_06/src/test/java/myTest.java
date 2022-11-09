import dao.StudentMapper;
import dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import utils.mybatiesUtile;

import java.util.List;

public class myTest {

    @Test
    public void test(){
        SqlSession sqlSession = mybatiesUtile.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();
        for (Student student1 : student) {
            System.out.println(student1);
        }

        sqlSession.close();
    }
}
