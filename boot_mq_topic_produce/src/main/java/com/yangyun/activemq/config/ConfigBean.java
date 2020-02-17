package com.yangyun.activemq.config;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Session;

/**
 * @ClassName ConfigBean
 * @Description:
 * @Author 86155
 * @Date 2020/2/3 15:38
 * @Version 1.0
 **/
@Configuration
@EnableScheduling
public class ConfigBean {

    @Value("${mytopic}")
    private String myTopic;

    @Bean
    public ActiveMQTopic activeMQTopic (){

        return new ActiveMQTopic(myTopic);
    }

//    public Session session (){
//        Session session = new ActiveMQSession();
//
//        return session;
//    }
}
