package cn.tzc.yk.controller;

import cn.tzc.yk.po.Commodity;
import cn.tzc.yk.po.CommodityHistory;
import cn.tzc.yk.serviceImpl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
public class CommodityController {

   @Autowired
   private CommodityServiceImpl commodityService;

   @RequestMapping("/getCommodities")
   @ResponseBody
   public List<Commodity> getCommodities(){
       List<Commodity> ls = null;
       try {
           ls = commodityService.getCommodities();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return ls;
   }

   @RequestMapping("/consumeCommodity")
   @ResponseBody
   public int consumeCommodity(@RequestParam(name = "sid") String sid, @RequestParam(name = "cid") int cid){
       int status = 0;
       try {
           status = commodityService.consumeCommodity(sid,cid);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return status;
   }

   @RequestMapping("/getConsumeHistory")
   @ResponseBody
   public List<CommodityHistory> getConsumeHistory(@RequestParam String sid){
       List<CommodityHistory> ls = null;
       try {
           ls = commodityService.getConsumpHistoryById(sid);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return ls;
   }

}
