package com.example.internshipProject.service;

import com.example.internshipProject.dto.BookingDTO;
import com.example.internshipProject.entity.Booking;
import com.example.internshipProject.entity.Room;
import com.example.internshipProject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    @Autowired
    public BookingRepository bookingRepository;

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }
    public boolean saveBooking(BookingDTO bookingDTO) {
        Room room = bookingDTO.getRoom();

        Optional<Booking> foundBooking = bookingRepository.findById(room.getID());

        if(!foundBooking.isPresent()) {
            return false;
        }

        Booking booking = new Booking(room, bookingDTO.getCheckIn(), bookingDTO.getCheckOut());

        bookingRepository.save(booking);

        return true;
    }
}
