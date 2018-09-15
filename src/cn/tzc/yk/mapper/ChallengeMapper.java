package cn.tzc.yk.mapper;

import cn.tzc.yk.po.Challenge;
import cn.tzc.yk.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChallengeMapper {
   public void addChallenge(Challenge challenge)throws Exception;
}
