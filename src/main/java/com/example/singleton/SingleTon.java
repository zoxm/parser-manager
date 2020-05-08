package com.example.singleton;

import com.example.service.MeettingService;
import org.springframework.stereotype.Component;

/**
 * @ClassName SingleTon
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-29 15:07
 * @Version 1.0
 **/
@Component
public class SingleTon {

    private MeettingService meettingService;
    private SingleTon(){

    }
}
