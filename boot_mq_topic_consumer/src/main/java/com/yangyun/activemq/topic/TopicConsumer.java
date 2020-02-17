package com.yangyun.activemq.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 * @ClassName QueueConsumer
 * @Description:
 * @Author 86155
 * @Date 2020/2/2 22:51
 * @Version 1.0
 **/
@Component
public class TopicConsumer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQTopic topic;

    public void receiveMessage (){
        String s = jmsMessagingTemplate.receiveAndConvert(topic, String.class);
        System.out.println(s);
    }

    @JmsListener(destination = "${mytopic}")
    public void receiveListenerMessage(TextMessage textMessage) throws JMSException {
        System.out.println(textMessage.getText());
    }
}
