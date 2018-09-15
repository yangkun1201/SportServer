package cn.tzc.yk.service;

import cn.tzc.yk.po.RunData;
import cn.tzc.yk.po.User;
import cn.tzc.yk.po.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RunDataService {
    public void addRunData(RunData runData) throws Exception;
    public RunData getHomeData(String id,String date) throws Exception;
    public List<UserInfo> getUserInfo()throws Exception;
    public Set<String> calendarData(String id)throws Exception;
}
