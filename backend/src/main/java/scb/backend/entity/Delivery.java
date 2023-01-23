package scb.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private Order order;

    @Enumerated
    private Status status;

    @Embedded
    private Client client;

    private String creator;   //todo String -> User after change auth

    public Delivery() {
    }

    public Delivery(Order order, Status status, Client client, String creator) {
        this.order = order;
        this.status = status;
        this.client = client;
        this.creator = creator;
    }

    public Delivery(Delivery delivery) {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String createdBy) {
        this.creator = createdBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
