package com.github.youssfbr.cursomc.entities.enums;

public enum ClientStatus {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int id;
    private String description;

    private ClientStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static ClientStatus toEnum(Integer id) {

        if (id == null) return null;

        for (ClientStatus x : ClientStatus.values()) {
            if (id.equals(x.getId())) return x;
        }
        throw new IllegalArgumentException("Invalid Id: " + id);
    }

}
