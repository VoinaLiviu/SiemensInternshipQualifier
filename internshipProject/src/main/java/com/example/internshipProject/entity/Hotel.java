package com.example.internshipProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Room> rooms = new HashSet<>();
    private String name;
    private double latitude;
    private double longitude;

    public Hotel (String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this. longitude = longitude;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }
}
