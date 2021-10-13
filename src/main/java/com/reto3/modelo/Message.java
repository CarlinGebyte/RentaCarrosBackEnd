package com.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    /**
     * Atributo idMessage
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idMessage;
    /**
     * Atributo MessageText
     */
    @Column(name = "messagetext")
    private String messageText;

    /**
     * Relación Muchos a uno tabla Car
     */
    @ManyToOne
    @JoinColumn(name = "idCar")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Car car;
    /**
     * Relación muchos a uno tabla Client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    // Getters y Setters

    /**
     * Getter idMessage
     * @return
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * Setter idMessage
     * @param idMessage
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * Getter MessageText
     * @return
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * Setter MessageText
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * Getter Car
     * @return
     */
    public Car getCar() {
        return car;
    }

    /**
     * Setter Car
     * @param car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Getter Client
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     * Setter Client
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
