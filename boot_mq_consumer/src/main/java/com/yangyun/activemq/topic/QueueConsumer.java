package com.yangyun.activemq.topic;

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
public class QueueConsumer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void receiveMessage (){
        String s = jmsMessagingTemplate.receiveAndConvert(queue, String.class);
        System.out.println(s);
    }

    @JmsListener(destination = "${myqueue}")
    public void receiveListenerMessage(TextMessage textMessage) throws JMSException {
        System.out.println(textMessage.getText());
    }
}
