package com.example.internshipProject.service;

import com.example.internshipProject.converters.RoomConverter;
import com.example.internshipProject.dto.RoomDTO;
import com.example.internshipProject.entity.Room;
import com.example.internshipProject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomConverter roomConverter;

    public List<RoomDTO> getAll() {
        List<RoomDTO> roomDTOs = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();

        for(Room room : rooms) {
            RoomDTO roomDTO = roomConverter.toRoomDTO(room);
            roomDTOs.add(roomDTO);
        }

        return roomDTOs;
    }

    public List<RoomDTO> getRoomsFromHotel(Double hotelID) {
        List<RoomDTO> roomsFromHotel = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();

        for(Room room : rooms) {
            if(room.getHotel().getID() == hotelID) {
                RoomDTO roomDTO = roomConverter.toRoomDTO(room);
                roomsFromHotel.add(roomDTO);
            }
        }

        return roomsFromHotel;
    }
}
