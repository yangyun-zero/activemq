package com.yangyun.activemq.embed;

import org.apache.activemq.broker.BrokerService;

/**
 * @ClassName EmbedActiveMQBroker
 * @Description: 嵌入式 ActiveMQ
 * @Author 86155
 * @Date 2020/2/2 13:35
 * @Version 1.0
 **/
public class EmbedActiveMQBroker {

    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
