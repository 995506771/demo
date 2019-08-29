package com.hz.demo.service.impl;

import com.hz.demo.dao.UserMapper;
import com.hz.demo.model.User;
import com.hz.demo.redis.RedisUtil;
import com.hz.demo.req.LoginReq;
import com.hz.demo.resp.CodeMsg;
import com.hz.demo.resp.Result;
import com.hz.demo.service.ILoginService;
import com.hz.demo.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *  登录接口 实现类
 */
@Service
public class LoginServiceImpl implements ILoginService {

    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result userLogin(LoginReq loginReq) {
        Map<String,String> map = new HashMap<String,String>();
        // 把前端传过来的 手机号存到map
        map.put("phone",loginReq.getMobile());
        // 再把map 传到 dao层接口 让他去数据库查
        User user = userMapper.checkPhone(map);
        // 判断查出来是不是有数据 是否为空
        if (ObjectUtils.isEmpty(user)){
            return Result.getFail(CodeMsg.MOBILE_NOT_EXIST.getCode(),CodeMsg.MOBILE_NOT_EXIST.getMsg());
        }

        // 再判断密码是否正确
        // 前端传过来的密码
        String password = loginReq.getPassword();
        // 把前端的密码 通过 密钥 MD5加密后
        String calcPass = MD5Util.formPassToDBPass(password,user.getSalt());
        // 数据库查出来的密码
        String dbPassword = user.getPassword();
        // 如果不正确就返回失败信息
        if(!calcPass.equals(dbPassword)){
            return Result.getFail(CodeMsg.PASSWORD_ERROR.getCode(),CodeMsg.PASSWORD_ERROR.getMsg());
        }

        // 走到这里 上面的都不符合 那就可以 登录进去了
        // 返回成功信息
        Result result = new Result();
        result.setCode(CodeMsg.SUCCESS.getCode());
        result.setMsg(CodeMsg.SUCCESS.getMsg());
        // 再把密码清空一下
        user.setPassword("");
        result.setData(user);

        //把信息放到 Redis缓存中
        String redisKey = user.getPhone()+user.getId();
        redisUtil.set(redisKey,user);

        return result;
    }
}
