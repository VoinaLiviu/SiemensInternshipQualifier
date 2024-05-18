package com.example.internshipProject.service;

import com.example.internshipProject.converters.ReviewConverter;
import com.example.internshipProject.dto.request.ReviewRequestDTO;
import com.example.internshipProject.dto.response.ReviewResponseDTO;
import com.example.internshipProject.entity.HotelEntity;
import com.example.internshipProject.entity.ReviewEntity;
import com.example.internshipProject.repository.HotelRepository;
import com.example.internshipProject.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReviewConverter reviewConverter;

    public List<ReviewResponseDTO> getAll() {
        List<ReviewResponseDTO> reviewDTOs = new ArrayList<>();
        List<ReviewEntity> reviews = reviewRepository.findAll();

        for(ReviewEntity review : reviews) {
            ReviewResponseDTO reviewDTO = reviewConverter.toReviewDTO(review);
            reviewDTOs.add(reviewDTO);
        }
        return reviewDTOs;
    }

    public List<ReviewResponseDTO> getByHotelId(long hotelID) {
        List<ReviewResponseDTO> reviewDTOs = new ArrayList<>();
        List<ReviewEntity> reviews = reviewRepository.findAll();

        for(ReviewEntity review : reviews) {
            if(review.getHotel().getID() == hotelID) {
                ReviewResponseDTO reviewDTO = reviewConverter.toReviewDTO(review);
                reviewDTOs.add(reviewDTO);
            }
        }

        return reviewDTOs;
    }

    public boolean saveReview(ReviewRequestDTO reviewDTO) {
        Optional<HotelEntity> foundHotel = hotelRepository.findById(reviewDTO.getHotelID());

        if(!foundHotel.isPresent()) {
            return false;
        }

        ReviewEntity review = reviewConverter.fromReviewDTO(reviewDTO);
        HotelEntity hotel = foundHotel.get();

        review.setHotel(hotel);
        reviewRepository.save(review);

        return true;
    }
}
