package com.hz.demo.dao;

import com.hz.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {

    /**
     *  根据手机号 查询用户信息
     * @param map
     * @return
     */
    User checkPhone(@Param("map")Map<String,String> map);

}
