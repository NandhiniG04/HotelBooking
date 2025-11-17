package com.example.hotelbooking.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Column(name = "room_number", unique = true, nullable = false)
    private String roomNumber;


    @NotNull
    @Positive
    private Integer capacity;


    public Room() {}


    public Room(String roomNumber, Integer capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
