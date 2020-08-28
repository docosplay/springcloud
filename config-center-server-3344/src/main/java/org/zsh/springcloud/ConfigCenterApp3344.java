package org.zsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 已集成bus&rabbitmq，调用 curl -X POST "localhost:3344/actuator/bus-refresh" 命令刷新
 * 想定点通知的话，可以使用 curl -X POST "localhost:3344/actuator/bus-refresh/config:3355"
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigCenterApp3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApp3344.class, args);
    }
}
