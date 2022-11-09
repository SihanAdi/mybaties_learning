package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
//    方法存在多个参数，所有参数前面必须jiashang@Param注解
//    基本类型的参数或者String类型，需要加上
//    引用类型不需要加
//    如果只有一个基本类型的话，可以忽略，但是建议大家都加上！
//    我们在SQL中 用的就是我们这里的 @ParamQ中设定的属性名！
    @Select("select * from user where id = #{identify}")
    User getUserById(@Param("identify") int id);
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    int insertUser(User user);

}
