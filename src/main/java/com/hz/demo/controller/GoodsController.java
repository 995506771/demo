package com.hz.demo.controller;

import com.hz.demo.service.IGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  加载商品 controller
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private final static Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private IGoodsService iGoodsService;

    @RequestMapping("/list")
    @ResponseBody
    public String goodsList(Model model, HttpServletRequest request, HttpServletResponse response){
        logger.info("接收到加载商品信息的请求");
        String html = iGoodsService.getAllSecKillGoods(model, request, response);

        return html;
    }



}
