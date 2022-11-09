package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Student;
import pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
//    List<Teacher> getTeacher();

    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);
}
