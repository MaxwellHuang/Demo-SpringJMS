package com.huanlian.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * User:Maxwell
 * Date:2015/2/9
 * Time:18:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jms.xml")
public class JMSTest {

    @Autowired
    private ProducerServiceImpl producerService;

    @Autowired
    @Qualifier("sessionDestination")
    private Destination destination;

    @Test
    public void test(){
        for (int i = 0; i < 3; i++) {
            producerService.sendMessage(destination,"消息"+i);
        }
    }


}
