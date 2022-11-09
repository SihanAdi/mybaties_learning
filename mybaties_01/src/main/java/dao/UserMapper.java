package dao;

import pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserMapper {
    //查询全部用户
    List<User> getUser();

    List<User> getUserLike(String value);
    //根据ID查询用户
    User getUserById(int id);
    //insert一个用户
    int addUser(User user);
    //map
    int addUser2(Map<String, Object> map);

    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(String name);
}
