package org.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudSleuthServiceApp8570 {

    public static void main(String[] args) {
        SpringApplication.run(CloudSleuthServiceApp8570.class, args);
    }
}
