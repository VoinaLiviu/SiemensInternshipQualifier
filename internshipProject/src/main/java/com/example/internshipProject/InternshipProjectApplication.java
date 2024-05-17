package com.example.internshipProject;

import com.example.internshipProject.service.HotelService;
import com.example.internshipProject.entity.Booking;
import com.example.internshipProject.entity.Room;
import com.example.internshipProject.domain.RoomType;
import com.example.internshipProject.entity.Hotel;
import com.example.internshipProject.repository.BookingRepository;
import com.example.internshipProject.repository.HotelRepository;
import com.example.internshipProject.repository.RoomRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class InternshipProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternshipProjectApplication.class, args);
	}

	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private BookingRepository bookingRepository;

	//TODO
	@Autowired
	private HotelService hotelService; //To be deleted !!!

	@Override
	public void run(String... args) throws Exception {

		hotelRepository.deleteAll();
		roomRepository.deleteAll();
		bookingRepository.deleteAll();

		String hotelsJson = "";

		try {
			File hotelsFile = new File("src/main/java/com/example/internshipProject/data/hotels.json");
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

				Hotel hotel = new Hotel(hotelName, latitude, longitude);

				hotelRepository.save(hotel);

				JSONArray currentRoomsArray = (JSONArray) currentHotel.get("rooms");

				for(int index1 = 0; index1 < currentRoomsArray.size(); index1++) {
					JSONObject currentRoom = (JSONObject) currentRoomsArray.get(index1);
					Long roomNumber = (Long) currentRoom.get("roomNumber");
					Long type = (Long) currentRoom.get("type");
					Long price = (Long) currentRoom.get("price");
					Boolean isAvailable = (Boolean) currentRoom.get("isAvailable");
					RoomType roomType = RoomType.DOUBLE; //TODO

					Room room = new Room(hotel, roomNumber, price, roomType, isAvailable);

					hotel.addRoom(room);
					roomRepository.save(room);

					Booking booking = new Booking(room, LocalDateTime.now(), LocalDateTime.of(2024, 8, 3, 12, 20));
					bookingRepository.save(booking);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
