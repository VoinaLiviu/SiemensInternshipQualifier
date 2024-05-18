package com.example.internshipProject.controller;

import com.example.internshipProject.dto.request.ReviewRequestDTO;
import com.example.internshipProject.dto.response.ReviewResponseDTO;
import com.example.internshipProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public List<ReviewResponseDTO> getAll() {
        return reviewService.getAll();
    }

    @PostMapping("/{id}")
    public List<ReviewResponseDTO> getByHotelId(@PathVariable long id) {
        return reviewService.getByHotelId(id);
    }

    @PutMapping("/add")
    public boolean saveReview(@RequestBody ReviewRequestDTO reviewDTO) {
        return reviewService.saveReview(reviewDTO);
    }
}
