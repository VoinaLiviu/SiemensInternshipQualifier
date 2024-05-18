package com.example.internshipProject.converters;

import com.example.internshipProject.dto.response.HotelResponseDTO;
import com.example.internshipProject.entity.HotelEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelConverter {
    public HotelResponseDTO toHotelDTO(HotelEntity hotel) {
        HotelResponseDTO hotelDTO = new HotelResponseDTO();
        hotelDTO.setID(hotel.getID());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setLatitude(hotel.getLatitude());
        hotelDTO.setLongitude(hotel.getLongitude());

        return hotelDTO;
    }
}
