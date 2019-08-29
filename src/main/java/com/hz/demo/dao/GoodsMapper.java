package com.hz.demo.dao;

import com.hz.demo.model.SecKillGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    /**
     *获取秒杀商品的列表
     * @return
     */
    List<SecKillGoods> getAllSecKillGoods();

}
