package com.aditya.ecommerce.service;

import com.aditya.ecommerce.exception.ProductException;
import com.aditya.ecommerce.model.Review;
import com.aditya.ecommerce.model.User;
import com.aditya.ecommerce.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);
}