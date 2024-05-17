package com.example.internshipProject.controller;

import com.example.internshipProject.service.BookingService;
import com.example.internshipProject.dto.BookingDTO;
import com.example.internshipProject.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @PutMapping("/add")
    public boolean saveBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.saveBooking(bookingDTO);
    }
}
