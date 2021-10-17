package com.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gama")
public class Gama {
    /**
     * Atributo idGama
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idGama;
    /**
     * Atributo Name
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo Description
     */
    @Column(name = "description")
    private String description;
    /**
     * Relación uno a muchos tabla Car
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "gama")
    @JsonIgnoreProperties("gama")
    private List<Car> car;

    // Getters y Setters

    /**
     * Getter idGama
     * @return
     */
    public Integer getIdGama() {
        return idGama;
    }

    /**
     * Setter idGama
     * @param idGama
     */
    public void setIdGama(Integer idGama) {
        this.idGama = idGama;
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
     * Getter Car
     * @return
     */
    public List<Car> getCars() {
        return car;
    }

    /**
     * Setter Car
     * @param cars
     */
    public void setCars(List<Car> cars) {
        this.car = cars;
    }
}
