package com.example.internshipProject.controller;

import com.example.internshipProject.service.HotelService;
import com.example.internshipProject.dto.HotelDTO;
import com.example.internshipProject.dto.RangeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    public List<HotelDTO> fetchHotels() {
        return hotelService.getAll();
    }

    @PostMapping("/in-range")
    public List<HotelDTO> getInRange(@RequestBody RangeDTO rangeDTO) {
        return hotelService.getInRange(rangeDTO);
    }
}
