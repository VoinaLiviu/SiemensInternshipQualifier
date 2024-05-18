package com.example.internshipProject.controller;

import com.example.internshipProject.service.HotelService;
import com.example.internshipProject.dto.response.HotelResponseDTO;
import com.example.internshipProject.dto.request.RangeRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    public List<HotelResponseDTO> fetchHotels() {
        return hotelService.getAll();
    }

    @PostMapping("/in-range")
    public List<HotelResponseDTO> getInRange(@RequestBody RangeRequestDTO rangeDTO) {
        return hotelService.getInRange(rangeDTO);
    }
}
