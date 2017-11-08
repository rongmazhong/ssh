package cn.rong.ssh.controller;

import cn.rong.ssh.domain.User;
import cn.rong.ssh.service.UserSer;
import cn.rong.ssh.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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
    @Autowired
    private UserSer userSer;


    /**
     * 使用验证码，自动注入defaultkaptcha
     * @param model
     * @return
     */
    @Autowired
    DefaultKaptcha defaultKaptcha;


    @RequestMapping("loginCon")
    public ModelAndView imgvrifyController(HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse,
                                           @RequestParam(value = "loginname")String name,
                                           @RequestParam(value = "loginpwd")String pwd){
        ModelAndView modelAndView = new ModelAndView();
        String loginname = httpServletRequest.getParameter("loginname");
        List list = userSer.getUser(name);
        System.out.println(list);
        String loginpwd = httpServletRequest.getParameter("loginpwd");
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        String parameter = httpServletRequest.getParameter("vrifyCode");
        System.out.println("Session vrifyCode " + captchaId+" from vrifyCode" +parameter);
        if (!loginname.equals("rong")){
            modelAndView.addObject("info","用户名错误");
            modelAndView.setViewName("login");
        }else {
            if (!loginpwd.equals("123")) {
                modelAndView.addObject("info", "密码错误");
                modelAndView.setViewName("login");
            }else {
                if (!captchaId.equals(parameter)) {
                    modelAndView.addObject("info", "验证码错误");
                    modelAndView.setViewName("login");
                } else {
                    modelAndView.addObject("info", "通过验证");
                    modelAndView.addObject("user", loginname);
                    modelAndView.setViewName("index");
                }
            }
        }
        return modelAndView;
    }


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

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //产生验证码字符串并保持到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode",createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        }catch (IllegalArgumentException e){
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.addHeader("Cache-Control","no-store");
        httpServletResponse.setHeader("Pragma","no-cache");
        httpServletResponse.setDateHeader("Expires",0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        servletOutputStream.write(captchaChallengeAsJpeg);
        servletOutputStream.flush();
        servletOutputStream.close();
    }
    /*@RequestMapping(value = "/user/{userid}",method = RequestMethod.GET)
    public User findusersByName(int userid){
        return userService.findOne(userid);
    }*/
}
