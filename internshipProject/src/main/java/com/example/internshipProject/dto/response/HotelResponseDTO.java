package com.example.internshipProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class HotelResponseDTO {
    private long ID;
    private String name;
    private double latitude;
    private double longitude;
}
