package com.hz.demo.controller;

import com.hz.demo.req.LoginReq;
import com.hz.demo.resp.Result;
import com.hz.demo.service.ICartService;
import com.hz.demo.service.ILoginService;
import com.hz.demo.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 *  登录用户 controller
 */
@Controller
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/love")
    public String gg(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/user/login")
    public Result login(HttpServletResponse response, HttpSession session, @Valid LoginReq loginReq){
        logger.info("接收到登录的请求:{}");
        Result result = loginService.userLogin(loginReq);
        // TODO 写cookie     18077200000
        return result;
    }

}
