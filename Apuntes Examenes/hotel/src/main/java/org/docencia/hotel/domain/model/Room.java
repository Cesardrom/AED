package org.docencia.hotel.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room {
    @Id
    String id;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    Hotel hotel;

    @Column(name = "number")
    Integer roomNumber;


    @Column(name = "price per night",nullable = false)
    private Float pricePerNight;

    @Column(name = "type")
    String type;

    public Room() {
    }

    public Room(String id, Hotel hotel, Integer roomNumber, Float pricePerNight, String type) {
        this.id = id;
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.type = type;
    }

    public Room(String id ){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Float getPricePerNight() {
        return this.pricePerNight;
    }

    public void setPricePerNight(Float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
