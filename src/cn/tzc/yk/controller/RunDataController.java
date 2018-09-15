package cn.tzc.yk.controller;

import cn.tzc.yk.po.*;
import cn.tzc.yk.serviceImpl.RunDataServiceImpl;
import cn.tzc.yk.serviceImpl.ScoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class RunDataController {

    @Autowired
    private RunDataServiceImpl runDataService;

    @Autowired
    private ScoreServiceImpl scoreService;

    @RequestMapping("/receiveRunData")
    @ResponseBody
    public String receiveRunData(@RequestBody RunData runData){
        System.out.println(runData);
        try {
            runDataService.addRunData(runData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Score score = new Score();
        score.setId(runData.getId());
        score.setScore(runData.getScore());
        List<Score> ls = null;
        try {
            ls = scoreService.getCurrntScore(runData.getId());
            if(ls.size()>0){
                int oldScore = ls.get(0).getScore();
                int newScore = oldScore+runData.getScore();
                score.setScore(newScore);
                scoreService.updateScore(score);
            }else{
                scoreService.addScore(score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "receive ok";
    }

    @RequestMapping("/getRinkingData")
    @ResponseBody
    public RankingData getRinkingData(@RequestParam String id){
        RankingData rd = null;
        try {
            rd = scoreService.getRanking(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rd;
    }

    @RequestMapping("/getHomeData")
    @ResponseBody
    public RunData getHomeData(@RequestParam(name = "id") String id,@RequestParam(name = "date") String date){
        RunData rd = null;
        try {
            rd = runDataService.getHomeData(id,date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rd;
    }

    @RequestMapping("/getUsersInfo")
    @ResponseBody
    public List<UserInfo> getUsersInfo(){
        List<UserInfo> ls = null;
        try {
            ls = runDataService.getUserInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ls;
    }


    @RequestMapping("/getCalendarData")
    @ResponseBody
    public List<CalendarDate> getCalendarData(@RequestParam String id){
        Set<String> set = null;
        List<CalendarDate> ls = new ArrayList<>();
        int n = 0;
        try {
            set = runDataService.calendarData(id);
            n = set.size()>30?30:set.size();
            for(String s:set){
                int year = Integer.parseInt(s.substring(0,4));
                int month = Integer.parseInt(s.substring(5,7));
                int day = Integer.parseInt(s.substring(8,10));
                //System.out.println(year+":"+month+":"+day);
                CalendarDate calendarDate = new CalendarDate();
                calendarDate.setYear(year);
                calendarDate.setMonth(month);
                calendarDate.setDay(day);
                ls.add(calendarDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("n:"+n);
        return ls.subList(0,n);
    }


}
