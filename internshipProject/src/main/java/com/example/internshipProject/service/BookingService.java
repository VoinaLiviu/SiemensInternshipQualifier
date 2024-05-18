package com.example.internshipProject.service;

import com.example.internshipProject.converters.BookingConverter;
import com.example.internshipProject.converters.RoomConverter;
import com.example.internshipProject.dto.request.BookingRequestDTO;
import com.example.internshipProject.dto.response.BookingResponseDTO;
import com.example.internshipProject.entity.BookingEntity;
import com.example.internshipProject.entity.RoomEntity;
import com.example.internshipProject.exceptions.BookingException;
import com.example.internshipProject.repository.BookingRepository;
import com.example.internshipProject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingConverter bookingConverter;
    @Autowired
    private RoomConverter roomConverter;

    public List<BookingResponseDTO> getAll() {
        List<BookingResponseDTO> bookingDTOs = new ArrayList<>();
        List<BookingEntity> bookings = bookingRepository.findAll();

        for(BookingEntity booking : bookings) {
            BookingResponseDTO bookingDTO = bookingConverter.toBookingDTO(booking);
            bookingDTOs.add(bookingDTO);
        }

        return bookingDTOs;
    }
    public BookingException saveBooking(BookingRequestDTO bookingDTO) {
        Optional<RoomEntity> foundRoom = roomRepository.findById(bookingDTO.getRoomID());

        if(!foundRoom.isPresent()) {
            return new BookingException("Unable to find room with the given ID!");
        }

        List<BookingEntity> bookings = bookingRepository.findAll();

        LocalDateTime desiredCheckIn = bookingDTO.getCheckIn();
        LocalDateTime desiredCheckOut = bookingDTO.getCheckOut();

        for(BookingEntity booking : bookings) {
            if(booking.getRoom().getID() == bookingDTO.getRoomID()) {
                LocalDateTime bookingCheckIn = booking.getCheckIn();
                LocalDateTime bookingCheckOut = booking.getCheckOut();
                if ((bookingCheckIn.isAfter(desiredCheckIn) && bookingCheckIn.isBefore(desiredCheckOut))
                        || (bookingCheckOut.isAfter(desiredCheckIn) && bookingCheckOut.isBefore(desiredCheckOut))) {
                    return new BookingException("Invalid booking interval! Choose a free interval");
                }
            }
        }

        RoomEntity room = foundRoom.get();

        BookingEntity booking = bookingConverter.fromBookingDTO(bookingDTO);
        booking.setRoom(room);

        bookingRepository.save(booking);

        return new BookingException("OK");
    }
}
