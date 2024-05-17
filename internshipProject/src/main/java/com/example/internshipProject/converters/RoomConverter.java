package com.example.internshipProject.converters;

import com.example.internshipProject.dto.RoomDTO;
import com.example.internshipProject.entity.Room;

public class RoomConverter {
    public RoomDTO toRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setID(room.getID());
        roomDTO.setHotel(room.getHotel());
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setAvailable(room.isAvailable());

        return roomDTO;
    }

    public Room fromRoomDTO(RoomDTO roomDTO) {
        Room room = new Room();
        room.setHotel(roomDTO.getHotel());
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setPrice(roomDTO.getPrice());
        room.setRoomType(roomDTO.getRoomType());
        room.setAvailable(roomDTO.isAvailable());

        return room;
    }
}
