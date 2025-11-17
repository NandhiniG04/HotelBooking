package com.example.hotelbooking.dto;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


public class ReservationRequest {
    @NotNull
    private Long roomId;


    @NotNull
    private Long customerId;


    @NotNull
    private LocalDate startDate;


    @NotNull
    private LocalDate endDate;


    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}