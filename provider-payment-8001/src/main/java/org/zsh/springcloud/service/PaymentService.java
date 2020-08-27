package org.zsh.springcloud.service;

import org.zsh.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
