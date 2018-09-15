package cn.tzc.yk.serviceImpl;

import cn.tzc.yk.mapper.RunDataMapper;
import cn.tzc.yk.mapper.ScoreMapper;
import cn.tzc.yk.po.RankingData;
import cn.tzc.yk.po.RunData;
import cn.tzc.yk.po.Score;
import cn.tzc.yk.service.RunDataService;
import cn.tzc.yk.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public void addScore(Score score) throws Exception {
        scoreMapper.AddScore(score);
    }

    @Override
    public List<Score> getCurrntScore(String id) throws Exception {
        List<Score> ls = scoreMapper.getCurrntScore(id);
        return ls;
    }

    @Override
    public void updateScore(Score score) throws Exception {
        scoreMapper.updateScore(score);
    }

    @Override
    public RankingData getRanking(String id) throws Exception {
        RankingData rd = new RankingData();
        List<Score> ls = scoreMapper.getRanking();
        int n = 0;
        for(Score s:ls){
            n++;
            if(s.getId().equals(id)){
                rd.setRanking(n);
                rd.setId(id);
                rd.setScore(s.getScore());
                break;
            }
        }
        return rd;
    }
}
