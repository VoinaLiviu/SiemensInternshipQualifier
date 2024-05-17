package com.example.internshipProject.Service;

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

    public List<HotelDTO> getAll() {
        List<HotelDTO> hotelDTOs = new ArrayList<>();
        List<Hotel> hotels = hotelRepository.findAll();

        for(Hotel hotel : hotels) {
            HotelDTO hotelDTO = new HotelDTO(hotel.getID(), hotel.getName(), hotel.getLatitude(), hotel.getLongitude());
            hotelDTOs.add(hotelDTO);
        }

        return hotelDTOs;
    }

    public List<Hotel> getInRange(RangeDTO rangeDTO) {
        Double latitude = rangeDTO.getLatitude();
        Double longitude = rangeDTO.getLongitude();
        int range = rangeDTO.getRange();
        List<Hotel> hotels = hotelRepository.findAll();
        List<Hotel> hotelsInRange = new ArrayList<>();

        for(Hotel hotel : hotels) {
            if(inRange(latitude, longitude, hotel.getLatitude(), hotel.getLongitude(), range)) {
                hotelsInRange.add(hotel);
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
