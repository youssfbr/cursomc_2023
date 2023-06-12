package com.github.youssfbr.cursomc.entities.enums;

public enum PaymentStatus {

    PENDING(1, "Pendente"),
    PAID(2, "Quitado"),
    CANCELED(3, "Cancelado");

    private int id;
    private String description;

    PaymentStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatus toEnum(Integer id) {

        if (id == null) return null;

        for (PaymentStatus x : PaymentStatus.values()) {
            if (id.equals(x.getId())) return x;
        }
        throw new IllegalArgumentException("Invalid Id: " + id);
    }

}
