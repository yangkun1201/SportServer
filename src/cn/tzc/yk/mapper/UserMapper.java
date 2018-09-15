package cn.tzc.yk.mapper;

import cn.tzc.yk.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

   public User GetUserById(String id)throws Exception;
   public void AddUser(User user)throws Exception;
   public List<User> Login(User user)throws Exception;
   public void updateUserById(@Param("id") String id, @Param("name") String name, @Param("tel") String tel)throws Exception;
   public void deleteById(String id)throws Exception;
}
