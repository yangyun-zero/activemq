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
public class JmsProduce {

    public static final String DEFAULT_BROKER_URL = "failover:(tcp://47.107.172.70:61612,tcp://47.107.172.70:61613,tcp://47.107.172.70:61614)?randomize=false";
//    public static final String DEFAULT_BROKER_URL = "tcp://47.107.172.70:61614";
//    public static final String DEFAULT_BROKER_URL = "nio://47.107.172.70:61608";

    public static final String QUEUE_NAME = "jdbc01";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        for(int i = 1; i<=3; i++){
            TextMessage textMessage = session.createTextMessage("JDBC------" + i);

            producer.send(textMessage);
        }
        session.commit();
        producer.close();
        session.close();
        connection.close();
        System.out.println("===========");
    }
}
