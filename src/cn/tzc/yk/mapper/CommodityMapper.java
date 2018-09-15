package cn.tzc.yk.mapper;

import cn.tzc.yk.po.Commodity;
import cn.tzc.yk.po.CommodityHistory;
import cn.tzc.yk.po.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface CommodityMapper {

  public List<Commodity> getCommodities()throws Exception;
  public Commodity getCommodityById(int id)throws Exception;
  public void addConsumpHistory(@Param("sid") String sid,@Param("cid") int cid,@Param("btime") long btime) throws Exception;
  public List<CommodityHistory> getConsumpHistoryById(@Param("sid") String sid) throws Exception;
}
