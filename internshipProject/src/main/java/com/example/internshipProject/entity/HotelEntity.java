package com.example.internshipProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @JsonIgnore
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RoomEntity> roomEntities = new HashSet<>();
    private String name;
    private double latitude;
    private double longitude;

    public HotelEntity(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this. longitude = longitude;
    }

    public void addRoom(RoomEntity room) {
        this.roomEntities.add(room);
    }
}
