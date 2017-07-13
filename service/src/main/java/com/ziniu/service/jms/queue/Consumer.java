package com.ziniu.service.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 20:45
 */
@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text){
        System.out.println(text);
    }

    public static void main(String[] args) throws Exception {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://192.168.10.55:61616");
        Connection connection = cf.createConnection();
        connection.start();
        //开启事务，

        final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue-20170504");
        MessageConsumer consumer = session.createConsumer(destination);
        int i=0;
        while(i<3) {
            i++;
            TextMessage message = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("收到消息：" + message.getText());
        }
        session.close();
        connection.close();
    }
}
