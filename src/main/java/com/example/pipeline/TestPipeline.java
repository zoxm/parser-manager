package com.example.pipeline;

import cn.hutool.log.StaticLog;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @ClassName TestPipeline
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-28 16:15
 * @Version 1.0
 **/
@Service
public class TestPipeline  implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        Object url = resultItems.get("url");
        StaticLog.info("url:  {}  ", url);
    }
}
