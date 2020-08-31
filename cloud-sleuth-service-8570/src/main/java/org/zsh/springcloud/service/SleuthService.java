package org.zsh.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-sleuth-service-8571")
public interface SleuthService {

    @GetMapping("/port")
    String port();
}