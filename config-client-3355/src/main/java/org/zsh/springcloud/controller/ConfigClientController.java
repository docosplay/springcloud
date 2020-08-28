package org.zsh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @Value("${config.version}")
    private Integer configVersion;

    @GetMapping("/config")
    public String see() {
        return "port:"+serverPort+",info:" + configInfo + ",version:" + configVersion;
    }
}
