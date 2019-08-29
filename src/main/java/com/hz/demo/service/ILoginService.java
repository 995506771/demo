package com.hz.demo.service;

import com.hz.demo.req.LoginReq;
import com.hz.demo.resp.Result;

/**
 *  登录 接口
 */
public interface ILoginService {

    /**
     *  登录方法
     * @param loginReq
     * @return
     */
    Result userLogin(LoginReq loginReq);

}
