package com.hz.demo.service;

import com.hz.demo.vo.GoodsVo;

import java.util.List;

public interface ICartService {

    List<GoodsVo> getGoods(String goodsId);

}
