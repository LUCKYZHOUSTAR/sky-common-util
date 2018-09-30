package com.lucky.web;

import lucky.sky.web.WebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:chaoqiang.zhou
 * @Date:Create in 上午9:44 2018/7/25
 */

@SpringBootApplication
public class BootStrap {

  public static void main(String[] args) {

    new WebApplication(BootStrap.class, args).run(false);
  }
}
