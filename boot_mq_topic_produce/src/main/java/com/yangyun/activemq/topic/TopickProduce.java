package com.yangyun.activemq.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName TopickProduce
 * @Description:
 * @Author 86155
 * @Date 2020/2/3 15:38
 * @Version 1.0
 **/
@Component
public class TopickProduce {

    @Autowired
    private JmsMessagingTemplate messagingTemplate;

    @Autowired
    private ActiveMQTopic topic;

    @Scheduled(fixedDelay = 3000)
    public void produceTopicMessage (){

        messagingTemplate.convertAndSend(topic, "topic messsage " + UUID.randomUUID().toString().substring(0, 6));

    }

}
