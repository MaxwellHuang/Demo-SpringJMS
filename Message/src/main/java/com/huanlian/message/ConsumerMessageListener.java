package com.huanlian.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * User:Maxwell
 * Date:2015/2/9
 * Time:17:20
 */
public class ConsumerMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        System.out.println("===========消费者接受到一个消息==============");
        try {
            System.out.println("消息内容是:"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println("===========================================");
    }
}
