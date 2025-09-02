package com.aditya.ecommerce.service;

import com.aditya.ecommerce.exception.ProductException;
import com.aditya.ecommerce.model.Product;
import com.aditya.ecommerce.model.Review;
import com.aditya.ecommerce.model.User;
import com.aditya.ecommerce.repository.ProductRepository;
import com.aditya.ecommerce.repository.ReviewRepository;
import com.aditya.ecommerce.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService{

    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;


    public ReviewServiceImplementation(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}