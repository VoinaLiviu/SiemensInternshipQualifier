package com.example.internshipProject.service;

import com.example.internshipProject.converters.RoomConverter;
import com.example.internshipProject.dto.response.RoomResponseDTO;
import com.example.internshipProject.entity.RoomEntity;
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

    public List<RoomResponseDTO> getAll() {
        List<RoomResponseDTO> roomDTOs = new ArrayList<>();
        List<RoomEntity> roomEntities = roomRepository.findAll();

        for(RoomEntity room : roomEntities) {
            RoomResponseDTO roomDTO = roomConverter.toRoomDTO(room);
            roomDTOs.add(roomDTO);
        }

        return roomDTOs;
    }

    public List<RoomResponseDTO> getRoomsFromHotel(Long hotelID) {
        List<RoomResponseDTO> roomsFromHotel = new ArrayList<>();
        List<RoomEntity> roomEntities = roomRepository.findAll();

        for(RoomEntity room : roomEntities) {
            if(room.getHotel().getID() == hotelID) {
                RoomResponseDTO roomDTO = roomConverter.toRoomDTO(room);
                roomsFromHotel.add(roomDTO);
            }
        }

        return roomsFromHotel;
    }
}
