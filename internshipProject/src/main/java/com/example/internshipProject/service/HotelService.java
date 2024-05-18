package com.example.internshipProject.service;

import com.example.internshipProject.converters.HotelConverter;
import com.example.internshipProject.dto.response.HotelResponseDTO;
import com.example.internshipProject.dto.request.RangeRequestDTO;
import com.example.internshipProject.entity.HotelEntity;
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

    public List<HotelResponseDTO> getAll() {
        List<HotelResponseDTO> hotelDTOs = new ArrayList<>();
        List<HotelEntity> hotelEntities = hotelRepository.findAll();

        for(HotelEntity hotel : hotelEntities) {
            HotelResponseDTO hotelDTO = hotelConverter.toHotelDTO(hotel);
            hotelDTOs.add(hotelDTO);
        }

        return hotelDTOs;
    }

    public List<HotelResponseDTO> getInRange(RangeRequestDTO rangeDTO) {
        Double latitude = rangeDTO.getLatitude();
        Double longitude = rangeDTO.getLongitude();
        int range = rangeDTO.getRange();
        List<HotelEntity> hotelEntities = hotelRepository.findAll();
        List<HotelResponseDTO> hotelsInRange = new ArrayList<>();

        for(HotelEntity hotel : hotelEntities) {
            if(inRange(latitude, longitude, hotel.getLatitude(), hotel.getLongitude(), range)) {
                HotelResponseDTO hotelDTO = hotelConverter.toHotelDTO(hotel);
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
