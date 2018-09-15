package cn.tzc.yk.mapper;

import cn.tzc.yk.po.RunData;
import cn.tzc.yk.po.UserInfo;

import java.util.List;

public interface RunDataMapper {

   public void AddRunData(RunData runData)throws Exception;
   public List<RunData> getHomeData(String id)throws Exception;
   public List<UserInfo> getUserInfo()throws Exception;
   public void deleteById(String id)throws Exception;
   public List<RunData> getCalendarData(String id)throws Exception;
}
