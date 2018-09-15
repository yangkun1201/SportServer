package cn.tzc.yk.serviceImpl;

import cn.tzc.yk.mapper.ChallengeMapper;
import cn.tzc.yk.mapper.RunDataMapper;
import cn.tzc.yk.mapper.ScoreMapper;
import cn.tzc.yk.mapper.UserMapper;
import cn.tzc.yk.po.Challenge;
import cn.tzc.yk.po.ResponseData;
import cn.tzc.yk.po.Score;
import cn.tzc.yk.po.User;
import cn.tzc.yk.service.ChallengeService;
import cn.tzc.yk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private ChallengeMapper challengeMapper;


    @Override
    public void addChallenge(Challenge challenge) throws Exception {
        challengeMapper.addChallenge(challenge);
    }
}
