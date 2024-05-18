package com.example.internshipProject.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RangeRequestDTO {
    private Double latitude;
    private Double longitude;
    private Integer range;
}
