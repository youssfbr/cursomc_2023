package com.github.youssfbr.cursomc.entities;

import com.github.youssfbr.cursomc.entities.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tb_payment_credit_card")
public class PaymentCreditCard extends Payment {
    private Integer numberInstallments;

    public PaymentCreditCard() {
    }

    public PaymentCreditCard(Long id, PaymentStatus paymentStatus, Order order, Integer numberInstallments) {
        super(id, paymentStatus, order);
        this.numberInstallments = numberInstallments;
    }

    public Integer getNumberInstallments() {
        return numberInstallments;
    }

    public void setNumberInstallments(Integer numberInstallments) {
        this.numberInstallments = numberInstallments;
    }
}
