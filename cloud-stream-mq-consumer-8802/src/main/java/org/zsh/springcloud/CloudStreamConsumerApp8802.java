package org.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumerApp8802 {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerApp8802.class, args);
    }
}