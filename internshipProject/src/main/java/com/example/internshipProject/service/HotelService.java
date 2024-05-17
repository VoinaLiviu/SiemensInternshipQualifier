package com.example.internshipProject.service;

import com.example.internshipProject.converters.HotelConverter;
import com.example.internshipProject.dto.HotelDTO;
import com.example.internshipProject.dto.RangeDTO;
import com.example.internshipProject.entity.Hotel;
import com.example.internshipProject.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    private final HotelConverter hotelConverter;

    public List<HotelDTO> getAll() {
        List<HotelDTO> hotelDTOs = new ArrayList<>();
        List<Hotel> hotels = hotelRepository.findAll();

        for(Hotel hotel : hotels) {
            HotelDTO hotelDTO = hotelConverter.toHotelDTO(hotel);
            hotelDTOs.add(hotelDTO);
        }

        return hotelDTOs;
    }

    public List<HotelDTO> getInRange(RangeDTO rangeDTO) {
        Double latitude = rangeDTO.getLatitude();
        Double longitude = rangeDTO.getLongitude();
        int range = rangeDTO.getRange();
        List<Hotel> hotels = hotelRepository.findAll();
        List<HotelDTO> hotelsInRange = new ArrayList<>();

        for(Hotel hotel : hotels) {
            if(inRange(latitude, longitude, hotel.getLatitude(), hotel.getLongitude(), range)) {
                HotelDTO hotelDTO = hotelConverter.toHotelDTO(hotel);
                hotelsInRange.add(hotelDTO);
            }
        }

        return hotelsInRange;
    }

    public boolean inRange(Double latitude, Double longitude, Double hotelLatitude, Double hotelLongitude, Integer range) {
        Double distance = Math.sqrt((hotelLatitude - latitude) * (hotelLatitude - latitude) + (hotelLongitude - longitude) * (hotelLongitude - longitude)) * 100;

        System.out.println(distance);

        return distance <= range;
    }
}
