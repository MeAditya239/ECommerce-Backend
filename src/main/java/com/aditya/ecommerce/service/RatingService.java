package com.aditya.ecommerce.service;

import com.aditya.ecommerce.exception.ProductException;
import com.aditya.ecommerce.model.Rating;
import com.aditya.ecommerce.model.User;
import com.aditya.ecommerce.request.RatingRequest;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;

    public List<Rating> getProductsRating(Long productId);
}