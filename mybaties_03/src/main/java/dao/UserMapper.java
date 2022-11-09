package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUser();


    //根据ID查询用户
    User getUserById(int id);
//分页
    List<User> getUserByLimit(Map<String, Integer> map);
}
