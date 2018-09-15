package cn.tzc.yk.serviceImpl;



import cn.tzc.yk.mapper.CommodityMapper;
import cn.tzc.yk.mapper.ScoreMapper;
import cn.tzc.yk.po.Commodity;
import cn.tzc.yk.po.CommodityHistory;
import cn.tzc.yk.po.Score;
import cn.tzc.yk.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Commodity> getCommodities() throws Exception {

        List<Commodity> ls = commodityMapper.getCommodities();

        return ls;
    }

    @Override
    public int consumeCommodity(String sid, int cid) throws Exception {
        int status = 0;
        Commodity commodity = commodityMapper.getCommodityById(cid);
        Score score = scoreMapper.getCurrntScore(sid).get(0);
        System.out.println(commodity.getPrice());
        if(score.getScore()>commodity.getPrice()){
            score.setScore(score.getScore()-(int)commodity.getPrice());
            scoreMapper.updateScore(score);
            status = 1;
        }else{
            status = 0;
        }
        commodityMapper.addConsumpHistory(sid,cid,System.currentTimeMillis());
        System.out.println(status);
        return status;
    }

    @Override
    public List<CommodityHistory> getConsumpHistoryById(String sid)throws Exception {

        List<CommodityHistory> ls = new ArrayList<>();
        ls = commodityMapper.getConsumpHistoryById(sid);
        for (CommodityHistory ch:ls){
            Commodity commodity = commodityMapper.getCommodityById(ch.getCid());
            ch.setName(commodity.getName());
            ch.setPrice(commodity.getPrice());
        }
        return ls;
    }
}
