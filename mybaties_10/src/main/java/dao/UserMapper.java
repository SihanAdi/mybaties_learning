package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {
    User queryUserById(@Param("id") int id);
}
