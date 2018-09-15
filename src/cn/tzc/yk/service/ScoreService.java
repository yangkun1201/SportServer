package cn.tzc.yk.service;

import cn.tzc.yk.po.RankingData;
import cn.tzc.yk.po.RunData;
import cn.tzc.yk.po.Score;

import java.util.List;

public interface ScoreService {
    public void addScore(Score score) throws Exception;
    public List<Score> getCurrntScore(String id) throws Exception;
    public void updateScore(Score score) throws Exception;
    public RankingData getRanking(String id) throws Exception;
}
