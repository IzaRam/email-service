package com.iza.it.model;

import jakarta.persistence.*;

@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String fromService;

    @Column
    private String message;

    @Column
    private String toClient;

    public Email() { }

    public Email(String fromService, String message, String toClient) {
        this.fromService = fromService;
        this.message = message;
        this.toClient = toClient;
    }

    public Email(int id, String fromService, String message, String toClient) {
        this.id = id;
        this.fromService = fromService;
        this.message = message;
        this.toClient = toClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromService() {
        return fromService;
    }

    public void setFromService(String fromService) {
        this.fromService = fromService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToClient() {
        return toClient;
    }

    public void setToClient(String toClient) {
        this.toClient = toClient;
    }

    @Override
    public String toString() {
        return "mail{" +
                "from='" + fromService + '\'' +
                ", message='" + message + '\'' +
                ", to='" + toClient + '\'' +
                '}';
    }
}
