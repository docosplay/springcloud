package org.sh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderConsulApp80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderConsulApp80.class, args);
    }
}
