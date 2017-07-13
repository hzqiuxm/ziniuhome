package com.ziniu.service.jms.queue;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;


/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/5 0005 10:29
 */
@Component
public class MessageSender {
    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    JmsTemplate  jmsTemplate;
    private String Queue = "default_queue";
    private String GoldQueue = "gold_queue";

    private Gson gson = new Gson();

    /**
     *
     * @param message
     * @param type
     */
    public void sendMessage(final String message, int type){

        try {
            String destination = this.Queue;
            if (1 == type){
                destination = GoldQueue;
            }

            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {

                    TextMessage textMessage = session.createTextMessage(message);

                    return textMessage;
                }
            });
        } catch (JmsException e) {
            e.printStackTrace();
            log.error("发送消息给消息队列失败! ",e);
        }

    }
}
