package org.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudSleuthServiceApp8571 {

    public static void main(String[] args) {
        SpringApplication.run(CloudSleuthServiceApp8571.class, args);
    }
}