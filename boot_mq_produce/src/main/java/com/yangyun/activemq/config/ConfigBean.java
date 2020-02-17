package com.yangyun.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @ClassName ConfigBean
 * @Description:
 * @Author 86155
 * @Date 2020/2/2 20:09
 * @Version 1.0
 **/
@Configuration
@EnableJms
@EnableScheduling
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public Queue queue (){

        return new ActiveMQQueue(myQueue);
    }
}
