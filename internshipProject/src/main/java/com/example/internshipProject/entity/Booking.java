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
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
    @Column(name = "check-in")
    private LocalDateTime checkIn;
    @Column(name = "check-out")
    private LocalDateTime checkOut;

    public Booking(Room room, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
