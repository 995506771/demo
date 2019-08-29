package com.hz.demo.req;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoginReq {

    @NotNull(message = "手机不能为空")
    private String mobile;

    @NotNull(message = "密码不能为空")
    @Length(min = 8,message = "密码最少在8个以内")
    private String password;

}
