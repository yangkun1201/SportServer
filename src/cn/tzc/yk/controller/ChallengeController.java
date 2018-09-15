package cn.tzc.yk.controller;

import cn.tzc.yk.po.*;
import cn.tzc.yk.serviceImpl.ChallengeServiceImpl;
import cn.tzc.yk.serviceImpl.ScoreServiceImpl;
import cn.tzc.yk.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class ChallengeController {

    @Autowired
    private ChallengeServiceImpl challengeService;

    @RequestMapping("/addChallenge")
    public String addChallenge(@RequestBody Challenge challenge){
        try {
            challengeService.addChallenge(challenge);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }




}
