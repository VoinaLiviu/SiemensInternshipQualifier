package com.example.internshipProject.test;

import com.example.internshipProject.entity.HotelEntity;
import com.example.internshipProject.entity.RoomEntity;
import com.example.internshipProject.repository.HotelRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TestHotelRepo {
    @Autowired
    private HotelRepository hotelRepository;

    @Test
    public void testSaveHotel() {
        Set<RoomEntity> rooms = new HashSet<>();
        HotelEntity hotel = new HotelEntity(1, rooms, "TestHotel", 25.00123, 46.00321);

        hotelRepository.save(hotel);

        Optional<HotelEntity> savedHotel = hotelRepository.findById(hotel.getID());

        assert (savedHotel.isPresent());
        hotelRepository.delete(hotel);
    }
}
