package com.github.youssfbr.cursomc.dtos;

import com.github.youssfbr.cursomc.entities.Payment;

public record PaymentResponseDTO(
        Long id,
        String paymentStatus
        ) {

    public PaymentResponseDTO(Payment payment) {
        this(
                payment.getId(),
                payment.getPaymentStatus().getDescription());
    }
}
