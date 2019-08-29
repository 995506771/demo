package com.hz.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo {

    private String goodsId;
    private String goodsName;
    private String goodsPrice;
    private String goodsImg;
    private String goodsDesc;
    private String goodsNum;


}
