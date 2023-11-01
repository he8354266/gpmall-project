package com.gmall.kafka.services;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import org.slf4j.Logger;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;


/**
 * @Description //TODO
 * @Date 2023/8/8 14:15
 * @Author hy
 **/
@Component
public class JobProcessor implements PageProcessor {
    private static Logger logger = LoggerFactory.getLogger("JobProcessor");
    private String url="https://search.51job.com/list/170200,000000,0000,00,9,99,%2B,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";

    @Override
    public void process(Page page) {
        Html html = page.getHtml();

    }

    private Site site = Site.me()
            .setCharset("utf-8")
            .setTimeOut(10000)
            .setRetrySleepTime(3000)
            .setSleepTime(3);

    @Override
    public Site getSite() {
        return site;
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 10 * 1000)
    public void process() {
        Spider.create(new JobProcessor())
                .addUrl(url)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(10)
//                .addPipeline(this.saveData)//指定把爬取的数据保存到SaveData类的ResultItems中
                .run();

    }
}
