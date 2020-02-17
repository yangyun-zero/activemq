package com.yangyun.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName MainAppConsumer
 * @Description:
 * @Author 86155
 * @Date 2020/2/2 22:46
 * @Version 1.0
 **/
@SpringBootApplication
public class MainAppTopicConsumer {

    public static void main(String[] args) {
        SpringApplication.run(MainAppTopicConsumer.class, args);
    }
}
