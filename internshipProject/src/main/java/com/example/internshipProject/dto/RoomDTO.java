package com.example.internshipProject.dto;

import com.example.internshipProject.domain.RoomType;
import com.example.internshipProject.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private long ID;
    private Hotel hotel;
    private long roomNumber;
    private long price;
    private RoomType roomType;
    private boolean isAvailable;
}
