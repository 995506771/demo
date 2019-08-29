package com.hz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 添加对 mapper 类的扫描    或者在每个 mapper 类上添加 @mapper 注解
@MapperScan(value = "com.hz.demo.dao")

/**
 *      @SpringBootApplication 包含下面三种
 *
 *  @Configuration ：标注一个类为配置类。
 * @EnableAutoConfiguration ：开启自动配置。
 * @ComponentScan ：自动收集所有的 Spring 组件
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
