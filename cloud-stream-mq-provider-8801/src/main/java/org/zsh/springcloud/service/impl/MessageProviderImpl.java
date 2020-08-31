package org.zsh.springcloud.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.zsh.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("message:"+message);
        return message;
    }
}
