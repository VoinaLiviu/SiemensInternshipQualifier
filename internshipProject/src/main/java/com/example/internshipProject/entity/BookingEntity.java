package com.example.internshipProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToOne(fetch = FetchType.EAGER)
    private RoomEntity room;
    @Column(name = "check-in")
    private LocalDateTime checkIn;
    @Column(name = "check-out")
    private LocalDateTime checkOut;

    public BookingEntity(RoomEntity room, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
