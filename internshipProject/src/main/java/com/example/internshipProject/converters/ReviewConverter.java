package com.example.internshipProject.converters;

import com.example.internshipProject.dto.response.HotelResponseDTO;
import com.example.internshipProject.dto.request.ReviewRequestDTO;
import com.example.internshipProject.dto.response.ReviewResponseDTO;
import com.example.internshipProject.entity.ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {
    @Autowired
    private HotelConverter hotelConverter;

    public ReviewResponseDTO toReviewDTO(ReviewEntity review) {
        ReviewResponseDTO reviewDTO = new ReviewResponseDTO();
        HotelResponseDTO hotelDTO = hotelConverter.toHotelDTO(review.getHotel());

        reviewDTO.setHotel(hotelDTO);
        reviewDTO.setContent(review.getContent());
        reviewDTO.setRating(review.getRating());

        return reviewDTO;
    }

    public ReviewEntity fromReviewDTO(ReviewRequestDTO reviewDTO) {
        ReviewEntity review = new ReviewEntity();

        review.setContent(reviewDTO.getContent());
        review.setRating(reviewDTO.getRating());

        return review;
    }
}
