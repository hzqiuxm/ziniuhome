package com.ziniu.service.jms.queue;


import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/5 0005 10:41
 */
@Component
public class ConsumerMessageListener implements MessageListener {
    private Logger log = Logger.getLogger(this.getClass());


    @Override
    @JmsListener(destination = "default_queue")
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("普通管道接收到了消息： " + textMessage.getText());
        } catch (JMSException e) {

            log.error("接收消息失败!",e);
        }
    }

    @JmsListener(destination = "gold_queue")
    public  void normalProcess(Message messages){
        TextMessage message = (TextMessage)messages;

        try {
            System.out.println("黄金管道接收到了消息： " + message.getText());
        } catch (JMSException e) {

            log.error("接收消息失败!",e);
        }
    }
}
