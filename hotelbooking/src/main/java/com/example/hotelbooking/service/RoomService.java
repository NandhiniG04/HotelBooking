package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
