package com.hz.demo.dao;

import com.hz.demo.model.GoodsInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository 注解标注一个持久层 mapper 接口
@Repository
public interface CartMapper {

    List<GoodsInfo> getGoodsById(@Param("goodsId") String goodsId);

}
