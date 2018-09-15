package cn.tzc.yk.service;

import cn.tzc.yk.po.Challenge;
import cn.tzc.yk.po.ResponseData;
import cn.tzc.yk.po.Score;
import cn.tzc.yk.po.User;

public interface ChallengeService {

    public void addChallenge(Challenge challenge)throws Exception;

}
