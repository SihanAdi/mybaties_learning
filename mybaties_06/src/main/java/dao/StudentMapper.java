package dao;

import pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生，和对应的老师
    List<Student> getStudent();
    List<Student> getStudent2();
}
