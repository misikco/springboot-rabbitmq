package com.rabbitmq.start.exchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello i am zzk";
        System.out.println(msgString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", msgString);
    }

}