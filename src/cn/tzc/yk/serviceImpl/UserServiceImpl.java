package cn.tzc.yk.serviceImpl;

import cn.tzc.yk.mapper.RunDataMapper;
import cn.tzc.yk.mapper.ScoreMapper;
import cn.tzc.yk.mapper.UserMapper;
import cn.tzc.yk.po.ResponseData;
import cn.tzc.yk.po.Score;
import cn.tzc.yk.po.User;
import cn.tzc.yk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private RunDataMapper runDataMapper;

    @Override
    public User getUserById(String id) throws Exception {
        User user = userMapper.GetUserById(id);
        return user;
    }

    @Override
    public void addUser(User user) throws Exception {
        userMapper.AddUser(user);
    }

    @Override
    public ResponseData login(User user) throws Exception {
        int statuscode = -2;
        List<User> ls = userMapper.Login(user);
        ResponseData responseData = new ResponseData();
        if(ls.size()==0) {
            statuscode = 0; //用户不存在
        }else{

            User cur = ls.get(0);
            if(cur.getPassword().equals(user.getPassword())){
                statuscode = 1; //密码正确
                responseData.setName(cur.getName());
            }else{
                statuscode = -1; //密码错误
            }
        }
        responseData.setStatuscode(statuscode);

        return responseData;
    }

    @Override
    public void ChangeInfo(String id, String name, String tel, Score score) throws Exception {
        userMapper.updateUserById(id,name,tel);
        if(scoreMapper.getCurrntScore(id).size()>0){
            scoreMapper.updateScore(score);
        }else{
            scoreMapper.AddScore(score);
        }

    }

    @Override
    public void deleteUser(String id) throws Exception {
        runDataMapper.deleteById(id);
        scoreMapper.deleteById(id);
        userMapper.deleteById(id);
    }
}
