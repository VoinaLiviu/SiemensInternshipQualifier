package com.example.internshipProject.dto;

import com.example.internshipProject.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class BookingDTO {
    private Room room;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
