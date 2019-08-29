package com.hz.demo.service.impl;

import com.hz.demo.dao.GoodsMapper;
import com.hz.demo.model.SecKillGoods;
import com.hz.demo.redis.RedisUtil;
import com.hz.demo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *  加载秒杀商品 接口实现类
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    /**
     *      生成 商品的 静态页面
     * @param model
     * @param request
     * @param response
     * @return
     */
    @Override
    public String getAllSecKillGoods(Model model, HttpServletRequest request, HttpServletResponse response) {
        // 1.redis 中获取静态页面
        String redisKey = "static_secKill_goods_html";
        String html = (String) redisUtil.get(redisKey);
        // 判断是否为空  不为空 就返回 这个页面
        if(!StringUtils.isEmpty(html)){
            return html;
        }

        // 如果 为空 那就从数据库查出来秒杀商品
        List<SecKillGoods> allSecKillGoods = goodsMapper.getAllSecKillGoods();
        model.addAttribute("goodsList",allSecKillGoods);

        // 再生成 静态页面
        //1.获取应用上下文
        IWebContext ctx =new WebContext(request,response,
                request.getServletContext(),request.getLocale(),model.asMap());
        //2.thymeleafViewResolve 生成页面
        html = thymeleafViewResolver.getTemplateEngine().process("goods_list",ctx);
        //3.静态页面缓存redis
        if(!StringUtils.isEmpty(html)){
            redisUtil.set(redisKey,html);
        }

        return html;
    }
}
