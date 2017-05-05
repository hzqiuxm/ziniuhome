package com.ziniu.service.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 20:42
 */
@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

//    @Scheduled(fixedDelay = 3000)
    public void send(){

        this.jmsMessagingTemplate.convertAndSend(this.queue,"hi,ActiveMQ!");
    }

    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.10.55:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //开启事务，消息确认方式为自动
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        //创建队列
        Destination destination = session.createQueue("my-queue-20170504");
        //生产者把消息传送到队列中
        MessageProducer producer = session.createProducer(destination);
        for(int i=0; i<3; i++) {
            TextMessage message = session.createTextMessage("message--"+i);
            Thread.sleep(1000);
            //通过消息生产者发出消息
            producer.send(message);
        }
        session.commit();
        session.close();
        connection.close();
    }

}
