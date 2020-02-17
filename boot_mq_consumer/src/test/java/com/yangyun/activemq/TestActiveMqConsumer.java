package com.yangyun.activemq;

import com.yangyun.activemq.topic.QueueConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName TestActiveMqConsumer
 * @Description:
 * @Author 86155
 * @Date 2020/2/2 22:55
 * @Version 1.0
 **/
@SpringBootTest(classes = MainApp_consumer.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMqConsumer {

    @Autowired
    private QueueConsumer queueConsumer;


    @Test
    public void testReceiveMessage (){
        queueConsumer.receiveMessage();
    }
}
