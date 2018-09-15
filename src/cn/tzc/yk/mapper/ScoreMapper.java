package cn.tzc.yk.mapper;

import cn.tzc.yk.po.RunData;
import cn.tzc.yk.po.Score;

import java.util.List;

public interface ScoreMapper {

   public void AddScore(Score score)throws Exception;
   public List<Score> getCurrntScore(String id)throws Exception;
   public void updateScore(Score score) throws Exception;
   public List<Score> getRanking()throws Exception;
   public void deleteById(String id)throws Exception;
}
