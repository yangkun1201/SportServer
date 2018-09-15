package cn.tzc.yk.controller;

import cn.tzc.yk.mapper.UserMapper;
import cn.tzc.yk.po.*;
import cn.tzc.yk.serviceImpl.ScoreServiceImpl;
import cn.tzc.yk.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ScoreServiceImpl scoreService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        System.out.println(user.getName());
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "register ok";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(@RequestBody User user){
        ResponseData rd = new ResponseData();
        try {
            rd = userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rd;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam String id){

        User user = null;

        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @RequestMapping("/test")
    @ResponseBody
    public User test(){
        User user = new User();
        user.setName("yangkun");
        return user;
    }

    @RequestMapping("/getUserInfoById")
    @ResponseBody
    public UserInfo getUserInfoById(@RequestParam String id){

        UserInfo userInfo = new UserInfo();
        User user = null;
        RankingData rankingData = null;
        try {
            user = userService.getUserById(id);
            rankingData = scoreService.getRanking(id);
            userInfo.setId(id);
            userInfo.setName(user.getName());
            userInfo.setTel(user.getTel());
            userInfo.setRanking(rankingData.getRanking());
            userInfo.setScore(rankingData.getScore());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userInfo;
    }

    @RequestMapping("/changeInfo")
    @ResponseBody
    public String changeInfo(@RequestBody UserInfo userInfo){
        Score score = new Score();
        score.setId(userInfo.getId());
        score.setScore(userInfo.getScore());
        try {
            userService.ChangeInfo(userInfo.getId(),userInfo.getName(),userInfo.getTel(),score);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public String deleteUserById(@RequestParam String id){

        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }

}
