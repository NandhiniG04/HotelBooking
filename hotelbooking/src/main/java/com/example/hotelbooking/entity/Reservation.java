package com.example.hotelbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    private Room room;


    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @NotNull
    private LocalDate startDate;


    @NotNull
    private LocalDate endDate;


    public Reservation() {}


    public Reservation(Room room, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.room = room; this.customer = customer; this.startDate = startDate; this.endDate = endDate;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}