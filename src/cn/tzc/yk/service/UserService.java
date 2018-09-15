package cn.tzc.yk.service;

import cn.tzc.yk.po.ResponseData;
import cn.tzc.yk.po.Score;
import cn.tzc.yk.po.User;

import java.util.List;

public interface UserService {

    public User getUserById(String id) throws Exception;
    public void addUser(User user) throws Exception;
    public ResponseData login(User user)throws Exception;
    public void ChangeInfo(String id, String name, String tel, Score score)throws Exception;
    public void deleteUser(String id)throws Exception;
}
