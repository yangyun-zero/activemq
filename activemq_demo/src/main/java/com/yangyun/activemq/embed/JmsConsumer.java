package com.yangyun.activemq.embed;

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

    public static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

    public static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
       ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(queue);


        while (true){
            Message message = consumer.receive();
            if (message != null){

                TextMessage textMessage = (TextMessage)message;

                System.out.println(textMessage.getText());
            } else {
                break;
            }
        }
    }
}
