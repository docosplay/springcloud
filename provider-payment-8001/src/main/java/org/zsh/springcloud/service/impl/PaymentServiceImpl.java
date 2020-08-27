package org.zsh.springcloud.service.impl;

import org.springframework.stereotype.Service;
import org.zsh.springcloud.dao.PaymentDao;
import org.zsh.springcloud.entities.Payment;
import org.zsh.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
