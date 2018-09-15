package cn.tzc.yk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManageController {

    @RequestMapping("/admin")
    public String login(){
        return "login";
    }


}
