package com.hz.demo.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  加载商品 相关接口
 */
public interface IGoodsService {

    /**
     *   获取所有秒杀商品
     * @param model
     * @param request
     * @param response
     * @return
     */
    String getAllSecKillGoods(Model model, HttpServletRequest request, HttpServletResponse response);

}
