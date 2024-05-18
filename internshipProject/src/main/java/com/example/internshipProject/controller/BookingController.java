package com.example.internshipProject.controller;

import com.example.internshipProject.dto.response.BookingResponseDTO;
import com.example.internshipProject.exceptions.BookingException;
import com.example.internshipProject.service.BookingService;
import com.example.internshipProject.dto.request.BookingRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public List<BookingResponseDTO> getAll() {
        return bookingService.getAll();
    }

    @PutMapping("/add")
    public BookingException saveBooking(@RequestBody BookingRequestDTO bookingDTO) {
        return bookingService.saveBooking(bookingDTO);
    }
}
