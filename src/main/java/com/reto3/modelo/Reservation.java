package com.reto3.modelo;

//import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    /**
     * Atributo id de la reservación
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idReservation;
    /**
     * Atributo Fecha inicial de la reservación
     */
    @Column(name = "startDate")
    //@JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    /**
     * Atributo Fecha de devolución
     */
    @Column(name = "devolutionDate")
    //@JsonFormat(pattern="yyyy-MM-dd")
    private Date devolutionDate;
    /**
     * Atributo estado de la reservación
     */
    @Column(name = "status")
    private String status = "created";

    /**
     * Relación muchos a uno tabla car
     */
    @ManyToOne
    @JoinColumn(name = "idReservation")
    @JsonIgnoreProperties("reservations")
    private Carros car;
    /**
     * Relación muchos a uno tabla client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    /**
     * Atributo score
     */
    @Column(name = "score")
    private Integer score;

    // Getter y Setter

    /**
     * Getter idReservation
     *
     * @return
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * Setter idReservation
     *
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * Getter startDate
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Setter startDate
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter devolutionDate
     *
     * @return
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * Setter devolutionDate
     *
     * @param devolutionDate
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * Getter status
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter status
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter car
     *
     * @return
     */
    public Carros getCar() {
        return car;
    }

    /**
     * Setter car
     *
     * @param carros
     */
    public void setCar(Carros carros) {
        this.car = carros;
    }

    /**
     * Getter client
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     * Setter client
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Getter score
     *
     * @return
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Setter score
     *
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}
