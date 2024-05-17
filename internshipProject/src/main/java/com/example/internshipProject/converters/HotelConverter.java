package com.example.internshipProject.converters;

import com.example.internshipProject.dto.HotelDTO;
import com.example.internshipProject.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelConverter {
    public HotelDTO toHotelDTO(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setID(hotel.getID());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setLatitude(hotel.getLatitude());
        hotelDTO.setLongitude(hotel.getLongitude());

        return hotelDTO;
    }

    public Hotel fromHotelDTO(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setLatitude(hotelDTO.getLatitude());
        hotel.setLongitude(hotelDTO.getLongitude());

        return hotel;
    }
}
