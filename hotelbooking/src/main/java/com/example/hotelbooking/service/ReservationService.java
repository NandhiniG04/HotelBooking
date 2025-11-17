package com.example.hotelbooking.service;
import com.example.hotelbooking.dto.ReservationRequest;
import com.example.hotelbooking.entity.Customer;
import com.example.hotelbooking.entity.Reservation;
import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.repository.CustomerRepository;
import com.example.hotelbooking.repository.ReservationRepository;
import com.example.hotelbooking.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {
    private final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              RoomRepository roomRepository,
                              CustomerRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
    }

 
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation createReservation(ReservationRequest req) {
        // basic date validation
        if (!req.getEndDate().isAfter(req.getStartDate())) {
            throw new IllegalArgumentException("endDate must be after startDate");
        }

        Room room = roomRepository.findById(req.getRoomId())
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        Customer customer = customerRepository.findById(req.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        LocalDate s = req.getStartDate();
        LocalDate e = req.getEndDate();

        long overlapping = reservationRepository.countOverlappingReservations(room.getId(), s, e);
        if (overlapping > 0) {
            logger.info("Attempt to double book room {} for {} - {}", room.getId(), s, e);
            throw new IllegalStateException("Room is already booked for the selected dates");
        }

        Reservation r = new Reservation(room, customer, s, e);
        Reservation saved = reservationRepository.save(r);
        logger.info("Reservation created id={} room={} customer={}", saved.getId(), room.getId(), customer.getId());
        return saved;
    }

   
}
