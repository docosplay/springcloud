package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 可以调用 curl -X POST "http://localhost:3355/actuator/refresh" 刷新最新配置
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApp3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp3366.class, args);
    }
}
