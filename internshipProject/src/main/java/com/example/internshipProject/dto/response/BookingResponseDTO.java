package com.example.internshipProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private RoomResponseDTO room;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}
