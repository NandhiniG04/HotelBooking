package com.example.hotelbooking.controller;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public Room create(@RequestBody Room room) {
        return roomService.save(room);
    }

    @GetMapping
    public List<Room> getAll() {
        return roomService.getAll();
    }
}
