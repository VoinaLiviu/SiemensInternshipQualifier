package com.example.internshipProject.service;

import com.example.internshipProject.entity.BookingEntity;
import com.example.internshipProject.entity.HotelEntity;
import com.example.internshipProject.entity.RoomEntity;
import com.example.internshipProject.enums.RoomTypeEnum;
import com.example.internshipProject.repository.BookingRepository;
import com.example.internshipProject.repository.HotelRepository;
import com.example.internshipProject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class InitializerService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public void initializeDatabaseFromFile(String filePath) {
        hotelRepository.deleteAll();
        roomRepository.deleteAll();
        bookingRepository.deleteAll();

        String hotelsJson = "";

        try {
            File hotelsFile = new File(filePath);
            Scanner scanner = new Scanner(hotelsFile);
            while (scanner.hasNextLine()) {
                hotelsJson += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

        //System.out.println(hotelsJson);

        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(hotelsJson);
            JSONArray hotelsArray = (JSONArray) object;

            for(int index = 0; index < hotelsArray.size(); index++) {
                JSONObject currentHotel = (JSONObject) hotelsArray.get(index);
                String hotelName = (String) currentHotel.get("name");
                Double latitude = (Double) currentHotel.get("latitude");
                Double longitude = (Double) currentHotel.get("longitude");

                HotelEntity hotel = new HotelEntity(hotelName, latitude, longitude);

                hotelRepository.save(hotel);

                JSONArray currentRoomsArray = (JSONArray) currentHotel.get("rooms");

                for(int index1 = 0; index1 < currentRoomsArray.size(); index1++) {
                    JSONObject currentRoom = (JSONObject) currentRoomsArray.get(index1);
                    Long roomNumber = (Long) currentRoom.get("roomNumber");
                    Long type = (Long) currentRoom.get("type");
                    Long price = (Long) currentRoom.get("price");
                    Boolean isAvailable = (Boolean) currentRoom.get("isAvailable");
                    RoomTypeEnum roomType = RoomTypeEnum.toEnum(Math.toIntExact(type));

                    RoomEntity room = new RoomEntity(hotel, roomNumber, price, roomType, isAvailable);

                    hotel.addRoom(room);
                    roomRepository.save(room);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
