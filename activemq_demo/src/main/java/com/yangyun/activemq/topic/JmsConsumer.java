package com.yangyun.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassName JmsProduce
 * @Description:
 * @Author 86155
 * @Date 2020/1/28 11:35
 * @Version 1.0
 **/
public class JmsConsumer {
    public static final String DEFAULT_BROKER_URL = "failover:(tcp://47.107.172.70:61612,tcp://47.107.172.70:61613,tcp://47.107.172.70:61614)?randomize=false";
//    public static final String DEFAULT_BROKER_URL = "tcp://47.107.172.70:61617";
//    public static final String DEFAULT_BROKER_URL = "nio://47.107.172.70:61610";

    public static final String QUEUE_NAME = "jdbc01";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
//        connectionFactory.setUserName("admin");
//        connectionFactory.setPassword("admin");

        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);


        Queue queue = session.createQueue(QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(queue);

        while(true){
            TextMessage textMessage = (TextMessage)consumer.receive(4000);
            if (null != textMessage){
                System.out.println("Consumer receive message ======> " + textMessage.getText());
            } else {
                break;
            }
        }

        session.commit();
        consumer.close();
        session.close();
        connection.close();
    }
}
