package com.example.internshipProject.controller;

import com.example.internshipProject.service.RoomService;
import com.example.internshipProject.dto.response.RoomResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public List<RoomResponseDTO> fetchRooms() {
        return roomService.getAll();
    }

    @PostMapping("/{hotelID}")
    public List<RoomResponseDTO> getRoomsFromHotel(@PathVariable Long hotelID) {
        return roomService.getRoomsFromHotel(hotelID);
    }
}
