package com.glowcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glowcare.dto.ReviewDto;
import com.glowcare.entity.Review;
import com.glowcare.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDto addReview(ReviewDto dto) {

        Review review = new Review();

        review.setUserId(dto.getUserId());
        review.setProductId(dto.getProductId());
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());

        Review savedReview = reviewRepository.save(review);

        return convertToDto(savedReview);
    }

    public List<ReviewDto> getProductReviews(Long productId) {

        List<Review> reviews =
                reviewRepository.findByProductId(productId);

        List<ReviewDto> result = new ArrayList<>();

        for (Review review : reviews) {
            result.add(convertToDto(review));
        }

        return result;
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDto convertToDto(Review review) {

        ReviewDto dto = new ReviewDto();

        dto.setId(review.getId());
        dto.setUserId(review.getUserId());
        dto.setProductId(review.getProductId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());

        return dto;
    }
}