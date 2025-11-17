package org.docencia.hotel.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.micrometer.common.lang.NonNull;

/**
 * @author DavidRiccio
 * @version 1.0.0
 */

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @NonNull
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "hotel")
    @Column(name = "rooms")
    private List<Room> rooms = new ArrayList<>();

    /**
     * Constructor vacio
     */
    public Hotel() {
    }

    /**
     * Constructor con todos los parametros
     * @param id id del Hotel
     * @param name nombre del hotel
     * @param address direccion del hotel
     * @param rooms habitaciones del hotel
     */
    public Hotel(String id, String name, String address, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

     public Hotel(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /**
     * Constructor con id
     * @param id id del hotel
     */
    public Hotel (String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }




    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Hotel)) {
            return false;
        }
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}