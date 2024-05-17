package com.example.internshipProject.controller;

import com.example.internshipProject.service.RoomService;
import com.example.internshipProject.dto.RoomDTO;
import com.example.internshipProject.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public List<RoomDTO> fetchRooms() {
        return roomService.getAll();
    }

    @GetMapping("/{hotelID}")
    public List<RoomDTO> getRoomsFromHotel(@PathVariable Double hotelID) {
        return roomService.getRoomsFromHotel(hotelID);
    }
}
