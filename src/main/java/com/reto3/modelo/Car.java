package com.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "car")
public class Car implements Serializable {
    /**
     * Atributo id del carro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idCar;
    /**
     * Atributo nombre del carro
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo marca del carro
     */
    @Column(name = "brand")
    private String brand;
    /**
     * Atributo Año del carro
     */
    @Column(name = "year")
    private int year;
    /**
     * Atributo descripción del carro
     */
    @Column(name = "description")
    private String description;

    /**
     * Relación Muchos a uno tabla Gama
     */
    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars")
    private Gama gama;
    /**
     * Relación uno a muchos tabla mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car", "client"})
    private List<Message> messages;
    /**
     * Relación uno a muchos tabla reservaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties("car")
    private List<Reservation> reservations;

    //Métodos getter y setter

    /**
     * Getter idCar
     * @return
     */
    public Integer getIdCar() {
        return idCar;
    }

    /**
     * Setter idCar
     * @param idCar
     */
    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
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
     * Getter Brand
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter Brand
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter Year
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter Year
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter Description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter Description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter Gama
     * @return
     */
    public Gama getGama() {
        return gama;
    }

    /**
     * Setter Gama
     * @param gama
     */
    public void setGama(Gama gama) {
        this.gama = gama;
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
