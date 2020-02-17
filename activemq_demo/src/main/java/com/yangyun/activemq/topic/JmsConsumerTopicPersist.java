package com.yangyun.activemq.topic;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassName JmsProduceTopicPersist
 * @Description: 持久化发布订阅
 * @Author 86155
 * @Date 2020/2/1 20:45
 * @Version 1.0
 **/
public class JmsConsumerTopicPersist {

    public static final String DEFAULT_BROKER_URL = "tcp://47.107.172.70:61616";

//    public static final String TOPIC_NAME = "Topic_Persist";

    public static final String TOPIC_NAME = "Jdbc_Topic_Persist";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);

        Connection connection = connectionFactory.createConnection();

        connection.setClientID("jdbc_consumer");

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "remrk");

        connection.start();

        Message message = durableSubscriber.receive();

        while(message != null){
            TextMessage textMessage = (TextMessage)message;
            System.out.println(textMessage.getText());

            message = durableSubscriber.receive(5000l);
        }

        session.close();
        connection.close();
    }
}
