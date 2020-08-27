package org.zsh.springcloud.service.fallback;

import org.springframework.stereotype.Service;
import org.zsh.springcloud.service.OrderHystrixService;

@Service
public class OrderHystrixServiceFallBack implements OrderHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "paymentInfoOk fallback！";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "paymentInfoTimeOut fallback";
    }
}
