package org.zsh.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "paymentInfoTimeOutFallBack",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),//方法超时时间
})
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "Thread :" + Thread.currentThread().getName() + ",id:" + id + ",OK!";
    }

    @HystrixCommand
    public String paymentInfoTimeOut(Integer id) {
        int sleepTime = 3;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thread :" + Thread.currentThread().getName() + ",id:" + id + ",耗时" + sleepTime + "秒钟!";
    }

    public String paymentInfoTimeOutFallBack(Integer id) {
        return "Thread :" + Thread.currentThread().getName() + ",id:" + id + ",FallBack!";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数！");
        }
        return "Thread :" + Thread.currentThread().getName() + ",id:" + id + "调用成功!";
    }

    public String paymentCircuitBreakerFallBack(Integer id) {
        return "Thread :" + Thread.currentThread().getName() + ",id:" + id + ",FallBack!";
    }
}
