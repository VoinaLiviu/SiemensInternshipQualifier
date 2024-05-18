package com.example.internshipProject.dto.response;

import com.example.internshipProject.dto.response.HotelResponseDTO;
import com.example.internshipProject.enums.RoomTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RoomResponseDTO {
    private long ID;
    private HotelResponseDTO hotel;
    private long roomNumber;
    private long price;
    private RoomTypeEnum roomType;
    private boolean isAvailable;
}
