package com.huanlian.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


/**
 * User:Maxwell
 * Date:2015/2/9
 * Time:17:13
 */
@Component
public class ProducerServiceImpl {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination,final String message){
        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("生产者发了一个消息：" + message);
        System.out.println("--------------------------------------------");
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }


}
