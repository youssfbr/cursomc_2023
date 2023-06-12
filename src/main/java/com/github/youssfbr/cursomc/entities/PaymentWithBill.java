package com.github.youssfbr.cursomc.entities;

import com.github.youssfbr.cursomc.entities.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_payment_bill")
public class PaymentWithBill extends Payment {
    private LocalDate maturityDate;
    private LocalDate paymentDate;

    public PaymentWithBill() {
    }

    public PaymentWithBill(Long id, PaymentStatus paymentStatus, Order order, LocalDate maturityDate, LocalDate  paymentDate) {
        super(id, paymentStatus, order);
        this.maturityDate = maturityDate;
        this.paymentDate = paymentDate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
