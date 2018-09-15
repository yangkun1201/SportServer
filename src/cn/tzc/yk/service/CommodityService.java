package cn.tzc.yk.service;

import cn.tzc.yk.po.Commodity;
import cn.tzc.yk.po.CommodityHistory;
import cn.tzc.yk.po.User;

import java.util.List;

public interface CommodityService {

    public List<Commodity> getCommodities()throws Exception;
    public int consumeCommodity(String sid,int cid)throws Exception;
    public List<CommodityHistory> getConsumpHistoryById(String sid)throws Exception;
}
