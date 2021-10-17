package com.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    /**
     * Atributo id Cliente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idClient;
    /**
     * Atributo email
     */
    @Column(name = "email")
    private String email;
    /**
     * Atributo password
     */
    @Column(name = "password")
    private String password;
    /**
     * Atributo Name
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo Age
     */
    @Column(name = "age")
    private int age;

    /**
     * Relación Uno a muchos tabla messages
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    /**
     * Relación Uno a muchos tabla reservations
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    // Getters y setters

    /**
     * Getter idClient
     * @return
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * Setter idCLient
     * @param idClient
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * Getter Email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter Password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter Password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter Name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter Age
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter Age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter Messages
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Setter Messages
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Getter Reservations
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Setter Reservations
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
