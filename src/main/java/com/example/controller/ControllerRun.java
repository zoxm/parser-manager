package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName ControllerRun
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-01 0:14
 * @Version 1.0
 **/
@Slf4j
@Component
public class ControllerRun implements ApplicationRunner {

    @Autowired
    private HuodongjiaController huodongjiaController;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        huodongjiaController.run();
    }
}
