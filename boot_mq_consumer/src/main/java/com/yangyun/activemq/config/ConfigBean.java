package com.yangyun.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * @ClassName ConfigBean
 * @Description:
 * @Author 86155
 * @Date 2020/2/2 22:47
 * @Version 1.0
 **/
@Configuration
//@EnableJms
public class ConfigBean {
    @Value("${myqueue}")
    private String queueName;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queueName);
    }
}
