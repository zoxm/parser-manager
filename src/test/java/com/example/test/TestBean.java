package com.example.test;

import com.example.DemoApplication;
import com.example.module.entity.WebSiteRuleEntity;
import com.example.pipeline.ConsolePipeline;
import com.example.processor.BaseProcessor;
import com.example.processor.impl.HuoDongJiaRepoPageProcessor;
import com.example.service.UrlService;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Spider;

/**
 * @ClassName TestBean
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-10 14:28
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestBean {

    @Autowired
    private UrlService urlService;
    @Autowired
    private BaseProcessor baseProcessor;
//    @Test
//    public void test00() {
//        List<UrlEntity> no = urlService.findAllByFlag("no");
//        System.out.println(no.size());
//    }

    @Autowired
    private ConsolePipeline consolePipeline;
    @Test
    public void test1() {
        Spider.create(new HuoDongJiaRepoPageProcessor())
                // 种子
                .addUrl("https://www.huodongjia.com/business")
                // 存储任务
//                .addPipeline(consolePipeline)
                // 线程
                .thread(1)
                // 开始
                .run();
    }
    @Test
    public void test2() {
        baseProcessor.run(new WebSiteRuleEntity());
    }

    @Test
    public void test3() {
//        WebSiteRuleEntity webSiteRuleEntity = new WebSiteRuleEntity();
//        webSiteRuleEntity.setId(123);
//
//        Serializable a = session.save("a", webSiteRuleEntity);
//        WebSiteRuleEntity a1 = (WebSiteRuleEntity)session.get("a", a);
//        System.out.println(a1.getId());
    }

}
