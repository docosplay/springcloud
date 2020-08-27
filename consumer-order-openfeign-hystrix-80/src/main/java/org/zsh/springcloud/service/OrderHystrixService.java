package org.zsh.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zsh.springcloud.service.fallback.OrderHystrixServiceFallBack;

@FeignClient(value = "provider-payment-hystrix", fallback = OrderHystrixServiceFallBack.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable(value = "id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable(value = "id") Integer id);
}