package com.github.youssfbr.cursomc.entities;

import com.github.youssfbr.cursomc.entities.enums.ClientStatus;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpfOrCnpj;
    private Integer clientStatus;
    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "tb_phones")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public Client() {
    }

    public Client(Long id, String name, String email, String cpfOrCnpj, ClientStatus clientStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.clientStatus = clientStatus.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public ClientStatus getClientStatus() {
        return ClientStatus.toEnum(clientStatus);
    }

    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus.getId();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
