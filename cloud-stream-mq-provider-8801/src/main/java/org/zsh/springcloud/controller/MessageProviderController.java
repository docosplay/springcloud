package org.zsh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zsh.springcloud.service.IMessageProvider;

import javax.annotation.Resource;

@RestController
public class MessageProviderController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage(){
        return messageProvider.send();
    }
}
