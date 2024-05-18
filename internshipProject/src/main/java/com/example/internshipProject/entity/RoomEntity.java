package com.example.internshipProject.entity;

import com.example.internshipProject.enums.RoomTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;
    @Column(name = "room_number")
    private long roomNumber;
    private long price;
    @Column(name = "room_type")
    private RoomTypeEnum roomType;
    @Column(name = "is_available")
    private boolean isAvailable;

    public RoomEntity(HotelEntity hotel, Long roomNumber, Long price, RoomTypeEnum roomType, Boolean isAvailable) {
        this.hotel = hotel;
        this. roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }
}

