package org.zsh.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.zsh.springcloud.entities.CommonResult;
import org.zsh.springcloud.entities.Payment;
import org.zsh.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult<>(200, serverPort + "插入成功", result);
        } else {
            return new CommonResult<Integer>(444, serverPort + "插入失败！");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult<>(200, serverPort + "查询成功!", result);
        } else {
            return new CommonResult<>(444, serverPort + "没有对应记录！");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object getPaymentDiscovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println(instance.getInstanceId()+" "+instance.getHost()+" "+instance.getPort());
        });

        return this.discoveryClient;
    }
}
