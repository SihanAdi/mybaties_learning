package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUser();


    //根据ID查询用户
    User getUserById(int id);
    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(String name);
}
