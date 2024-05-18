package com.example.internshipProject.converters;

import com.example.internshipProject.dto.response.HotelResponseDTO;
import com.example.internshipProject.dto.response.RoomResponseDTO;
import com.example.internshipProject.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter {
    @Autowired
    private HotelConverter hotelConverter;

    public RoomResponseDTO toRoomDTO(RoomEntity room) {
        RoomResponseDTO roomDTO = new RoomResponseDTO();
        HotelResponseDTO hotelDTO = hotelConverter.toHotelDTO(room.getHotel());

        roomDTO.setID(room.getID());
        roomDTO.setHotel(hotelDTO);
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setAvailable(room.isAvailable());

        return roomDTO;
    }
}
