package com.rabbitmq.practice1.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.practice1.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/29.
 */
@Component
public class SimpleListener implements ChannelAwareMessageListener {

    private static final Logger log= LoggerFactory.getLogger(SimpleListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onMessage(Message message){}


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long tag=message.getMessageProperties().getDeliveryTag();

        try {
            byte[] msg=message.getBody();
            User user=objectMapper.readValue(msg,User.class);
            log.info("简单消息监听确认机制监听到消息4： {} ",user);

            //int i=1/0;

            channel.basicAck(tag,true);
        }catch (Exception e){
            log.error("简单消息监听确认机制发生异常4：",e.fillInStackTrace());

            channel.basicReject(tag,false);
        }
    }
}
































