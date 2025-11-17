package com.example.hotelbooking.controller;

import com.example.hotelbooking.dto.ReservationRequest;
import com.example.hotelbooking.entity.Reservation;
import com.example.hotelbooking.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public Reservation reserve(@RequestBody ReservationRequest request) {
        return reservationService.createReservation(request);
    }
}
