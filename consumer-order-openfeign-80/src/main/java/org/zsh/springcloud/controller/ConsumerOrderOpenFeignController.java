package org.zsh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zsh.springcloud.entities.CommonResult;
import org.zsh.springcloud.entities.Payment;
import org.zsh.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

@RestController
public class ConsumerOrderOpenFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
