package com.example.hotelbooking.repository;
import com.example.hotelbooking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // count overlapping reservations for a room
    @Query("""
      select count(r) from Reservation r 
      where r.room.id = :roomId
        and not (r.endDate <= :startDate or r.startDate >= :endDate)
    """)
    long countOverlappingReservations(@Param("roomId") Long roomId,
                                      @Param("startDate") LocalDate startDate,
                                      @Param("endDate") LocalDate endDate);
}
