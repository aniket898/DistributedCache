package com.aniket.distributed.local.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisMessageSubscriber {

    private static final Logger logger = LoggerFactory.getLogger(RedisMessageSubscriber.class);

    public static List<String> messageList = new ArrayList<String>();

    public void onMessage(final Message message, final byte[] pattern) {
        messageList.add(message.toString());
        logger.info("Message received: " + new String(message.getBody()));
    }

    public void receiveTaxiRideTopicNotifications(final Message message, final byte[] pattern) {
        messageList.add(message.toString());
        logger.info("Message received: " + new String(message.getBody()));
    }

    public void receiveKeyspaceTopicNotifications(final Message message, final byte[] pattern) {
        messageList.add(message.toString());
        logger.info("Message received: " + new String(message.getBody()));
    }

}
