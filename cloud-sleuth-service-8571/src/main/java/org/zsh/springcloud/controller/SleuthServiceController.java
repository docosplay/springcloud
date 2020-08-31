package org.zsh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SleuthServiceController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/port")
    public String port(){
        return serverPort + "：" + UUID.randomUUID().toString();
    }
}
