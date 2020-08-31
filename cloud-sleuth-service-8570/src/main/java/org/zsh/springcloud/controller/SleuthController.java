package org.zsh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zsh.springcloud.service.SleuthService;

import javax.annotation.Resource;

@RestController
public class SleuthController {

    @Resource
    private SleuthService sleuthService;

    @GetMapping("/remotePort")
    public String getRemotePort(){
        return sleuthService.port();
    }
}
