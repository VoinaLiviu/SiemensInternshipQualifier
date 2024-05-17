package com.example.internshipProject.domain;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    SUITE(3),
    MATRIMONIAL(4);

    public final int label;

    private RoomType(int label) {
        this.label = label;
    }
}