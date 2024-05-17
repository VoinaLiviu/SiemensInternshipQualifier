package com.example.internshipProject.Service;

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

    public List<RoomDTO> getAll() {
        List<RoomDTO> roomDTOs = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();

        for(Room room : rooms) {
            RoomDTO roomDTO = new RoomDTO(room.getID(), room.getHotel(), room.getRoomNumber(), room.getPrice(), room.getRoomType(), room.isAvailable());
            roomDTOs.add(roomDTO);
        }

        return roomDTOs;
    }

    public List<Room> getRoomsFromHotel(Double hotelID) {
        List<Room> roomsFromHotel = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();

        for(Room room : rooms) {
            if(room.getHotel().getID() == hotelID) {
                roomsFromHotel.add(room);
            }
        }

        return roomsFromHotel;
    }
}
