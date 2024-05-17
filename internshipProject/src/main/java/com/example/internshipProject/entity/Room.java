package com.example.internshipProject.entity;

import com.example.internshipProject.domain.RoomType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Column(name = "room_number")
    private long roomNumber;
    private long price;
    @Column(name = "room_type")
    private RoomType roomType;
    @Column(name = "is_available")
    private boolean isAvailable;

    public Room(Hotel hotel, Long roomNumber, Long price, RoomType roomType, Boolean isAvailable) {
        this.hotel = hotel;
        this. roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }
}

