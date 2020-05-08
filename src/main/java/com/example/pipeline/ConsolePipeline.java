package com.example.pipeline;

import com.example.module.entity.MeettingEntity;
import com.example.service.MeettingService;
import com.example.service.PageService;
import com.example.service.impl.MeettingServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.lang.reflect.Field;

/**
 * Write results in console.<br>
 * Usually used in test.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
@Service
public class ConsolePipeline implements Pipeline {

    @Autowired
    private PageService pageService;
    @Autowired
    private MeettingService meettingService;

    @Override
    public void process(ResultItems resultItems, Task task) {

       // 存储逻辑
        String name = resultItems.get("name").toString();
        if (StringUtils.isNotEmpty(name)){
            MeettingEntity meettingEntity = new MeettingEntity();
            meettingEntity
                    .setName(resultItems.get("name").toString())
                    .setTag(resultItems.get("tag").toString())
                    .setGuide(resultItems.get("guide").toString())
                    .setGuest(resultItems.get("guest").toString())
                    .setTime(resultItems.get("time").toString())
                    .setCompany(resultItems.get("company").toString())
                    .setLocation(resultItems.get("location").toString())
                    .setSchedule(resultItems.get("schedule").toString())
                    .setIntroduce(resultItems.get("introduce").toString())
                    .setContent(resultItems.get("content").toString())
                    .setImg(resultItems.get("img").toString())
                    .setUrl(resultItems.get("url").toString())
                    .setScale(resultItems.get("scale").toString())
                    ;
//            System.out.println("meettingService\t" + this.meettingService);
            this.meettingService.save(meettingEntity);
        }
    }
}
