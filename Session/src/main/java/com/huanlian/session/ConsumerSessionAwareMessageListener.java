package com.huanlian.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * User:Maxwell
 * Date:2015/2/9
 * Time:17:35
 */
@Component
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Override
    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        System.out.println("****************session消费者受到一个消息****************");
        System.out.println("消息内容是:"+textMessage.getText());
        System.out.println("*******************************************************");
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("已读");
        producer.send(message);
        producer.close();
    }
}
