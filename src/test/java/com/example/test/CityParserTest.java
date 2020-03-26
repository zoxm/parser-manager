package com.example.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.log.StaticLog;
import com.example.service.data.*;

import java.util.List;

/**
 * @ClassName CityParserTest
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-01-07 17:02
 * @Version 1.0
 **/

public class CityParserTest {
    private static final String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2018/index.html";

    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
        // -------这是执行过程--------------
        cityParserDecorator();
        // ---------------------------------
        long interval = timer.interval();// 花费毫秒数
        long intervalMinute = timer.intervalMinute();// 花费分钟数
        StaticLog.info("本次程序执行 花费毫秒数: {} ,   花费分钟数:{} . ", interval, intervalMinute);
    }

    private static List<Node> cityParserDecorator() {

        ICityParser cityParser = new CityParser();

        // 1. 先查经纬度
        ICityParser locationCityParser = new LocationCityParserDecorator(cityParser);

        // 展示sql
        ICityParser sqlCityParser = new SqlCityParserDecorator(locationCityParser);

        // 打印json
        ICityParser jsonCityParser = new JsonCityParserDecorator(sqlCityParser);

        List<Node> parseProvinces = jsonCityParser.parseProvinces(url);

        return parseProvinces;
    }
//
//————————————————
//    版权声明：本文为CSDN博主「性情中人1993」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//    原文链接：https://blog.csdn.net/qq_38765404/article/details/88537020
}
