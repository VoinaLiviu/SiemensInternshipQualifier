package com.example.internshipProject.converters;

import com.example.internshipProject.dto.request.BookingRequestDTO;
import com.example.internshipProject.dto.response.RoomResponseDTO;
import com.example.internshipProject.dto.response.BookingResponseDTO;
import com.example.internshipProject.entity.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingConverter {
    @Autowired
    private RoomConverter roomConverter;
    public BookingResponseDTO toBookingDTO(BookingEntity booking) {
        BookingResponseDTO bookingDTO = new BookingResponseDTO();
        RoomResponseDTO roomDTO = roomConverter.toRoomDTO(booking.getRoom());

        bookingDTO.setRoom(roomDTO);
        bookingDTO.setCheckIn(booking.getCheckIn());
        bookingDTO.setCheckOut(booking.getCheckOut());

        return bookingDTO;
    }

    public BookingEntity fromBookingDTO(BookingRequestDTO bookingDTO) {
        BookingEntity booking = new BookingEntity();

        booking.setCheckIn(bookingDTO.getCheckIn());
        booking.setCheckOut(bookingDTO.getCheckOut());

        return booking;
    }
}
