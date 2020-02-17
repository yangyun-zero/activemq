package com.yangyun.activemq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @ClassName QueueProduce
 * @Description:
 * @Author 86155
 * @Date 2020/2/2 20:09
 * @Version 1.0
 **/
@Component
public class QueueProduce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void produceMessage(){
        jmsMessagingTemplate.convertAndSend(queue, UUID.randomUUID().toString().substring(0, 6));
    }

    // 定时发送 需要配合 @EnableScheduling 注解
    @Scheduled(fixedDelay = 3000)
    public void produceMessageScheduled(){
        jmsMessagingTemplate.convertAndSend(queue, UUID.randomUUID().toString().substring(0, 6));
        System.out.println("produceMessageScheduled send ok");
    }
}
