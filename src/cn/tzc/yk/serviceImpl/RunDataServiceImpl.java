package cn.tzc.yk.serviceImpl;

import cn.tzc.yk.mapper.RunDataMapper;
import cn.tzc.yk.mapper.UserMapper;
import cn.tzc.yk.po.RunData;
import cn.tzc.yk.po.User;
import cn.tzc.yk.po.UserInfo;
import cn.tzc.yk.service.RunDataService;
import cn.tzc.yk.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RunDataServiceImpl implements RunDataService {

    @Autowired
    private RunDataMapper runDataMapper;
    @Autowired
    private ScoreServiceImpl scoreService;

    @Override
    public void addRunData(RunData runData) throws Exception {
        runDataMapper.AddRunData(runData);
    }

    @Override
    public RunData getHomeData(String id,String date) throws Exception {
        List<RunData> ls = runDataMapper.getHomeData(id);
        RunData runData = new RunData();
        double distance = 0;
        double calories = 0;
        //System.out.println("size "+ls.size());
        for(RunData rd:ls){
           if (rd.getStartTime()!=null&&rd.getStartTime().contains(date)){
                distance+= rd.getTotalDistance();
                calories+= rd.getCalories();
                //System.out.println(rd.getStartTime()+":"+rd.getTotalDistance()+""+rd.getCalories());
            }
        }
        runData.setTotalDistance(distance);
        runData.setCalories(calories);
        return runData;
    }

    @Override
    public List<UserInfo> getUserInfo() throws Exception {
        List<UserInfo> ls = runDataMapper.getUserInfo();
        for(UserInfo userInfo:ls){
            userInfo.setRanking(scoreService.getRanking(userInfo.getId()).getRanking());
        }
        return ls;
    }

    @Override
    public Set<String> calendarData(String id) throws Exception {
        List<RunData> ls = runDataMapper.getCalendarData(id);
        Set<String> set = new HashSet<>();
        for (RunData s:ls){
            if(s.getStartTime()!=null){
                String date = s.getStartTime().substring(0,10);
                //System.out.println(date);
                set.add(date);
            }
        }
        return set;
    }
}
