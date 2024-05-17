package com.example.internshipProject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RangeDTO {
    private Double latitude;
    private Double longitude;
    private Integer range;
}
