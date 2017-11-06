package cn.rong.ssh.controller;

import cn.rong.ssh.domain.User;
import cn.rong.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: rong
 * Description: 首页
 * Data: Create in 上午 9:34 17.11.2
 * Package: cn.rong.ssh.controller
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public java.lang.String index(Model model){
        model.addAttribute("hello","world");
        return "index";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public java.lang.String hello(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/user")
    public List<User> getAll(){
        return userService.getAll();
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    /*@RequestMapping(value = "/user/{userid}",method = RequestMethod.GET)
    public User findusersByName(int userid){
        return userService.findOne(userid);
    }*/
}
