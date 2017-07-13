package com.ziniu.service.jms.queue;

import org.apache.activemq.transport.TransportListener;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/5 0005 10:45
 */
public class ActiveMQTransportListener implements TransportListener {

    private Logger log = Logger.getLogger(this.getClass());
    /**
     * 对消息传输命令进行监控
     * @param command
     */
    @Override
    public void onCommand(Object command) {

    }

    /**
     * 对监控到的异常进行触发
     * @param error
     */
    @Override
    public void onException(IOException error) {

        log.error("onException -> 消息服务器连接错误......", error);
    }

    /**
     * 当failover时触发
     */
    @Override
    public void transportInterupted() {

        log.warn("transportInterupted -> 消息服务器连接发生中断...");
    }

    /**
     * 监控到failover恢复后进行触发
     */
    @Override
    public void transportResumed() {

        log.info("transportResumed -> 消息服务器连接已恢复...");
    }
}
