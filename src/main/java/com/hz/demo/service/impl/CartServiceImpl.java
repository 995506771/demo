package com.hz.demo.service.impl;

import com.hz.demo.dao.CartMapper;
import com.hz.demo.model.GoodsInfo;
import com.hz.demo.service.ICartService;
import com.hz.demo.vo.GoodsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<GoodsVo> getGoods(String goodsId) {
        List<GoodsVo> list = new ArrayList<GoodsVo>();

        List<GoodsInfo> goodsById = cartMapper.getGoodsById(goodsId);
        for (GoodsInfo g:goodsById) {
            GoodsVo goodsVo = new GoodsVo();
            BeanUtils.copyProperties(g,goodsVo);
            list.add(goodsVo);
        }
        return list;
    }
}
