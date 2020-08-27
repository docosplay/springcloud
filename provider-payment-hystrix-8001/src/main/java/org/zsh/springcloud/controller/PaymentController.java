package org.zsh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zsh.springcloud.service.PaymentService;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("payment/hystrix")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    public PaymentService paymentService;


    @GetMapping("/ok/{id}")
    public String paymentInfoOk(@PathVariable(value = "id") Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable(value = "id") Integer id) {
        return paymentService.paymentInfoTimeOut(id);
    }

    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreakerTest(@NotNull @PathVariable(value = "id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
