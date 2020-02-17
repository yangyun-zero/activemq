package com.yangyun.activemq;

import com.yangyun.activemq.produce.QueueProduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @ClassName TestActiveMq
 * @Description:
 * @Author 86155
 * @Date 2020/2/2 20:27
 * @Version 1.0
 **/
@SpringBootTest(classes = MainApp_produce.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMq {

    @Resource
    private QueueProduce queueProduce;

    @Test
    public void testSend(){
        queueProduce.produceMessage();
    }
}
