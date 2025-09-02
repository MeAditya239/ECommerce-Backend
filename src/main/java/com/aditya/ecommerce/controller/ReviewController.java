package com.aditya.ecommerce.controller;

import com.aditya.ecommerce.exception.ProductException;
import com.aditya.ecommerce.exception.UserException;
import com.aditya.ecommerce.model.Review;
import com.aditya.ecommerce.model.User;
import com.aditya.ecommerce.request.ReviewRequest;
import com.aditya.ecommerce.service.RatingService;
import com.aditya.ecommerce.service.ReviewService;
import com.aditya.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {


    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
        public ResponseEntity<Review> createReviewReview (@RequestBody ReviewRequest req,
                                                          @RequestHeader("Authorization") String jwt) throws UserException, ProductException {

        User user = userService.findUserProfileByJwt(jwt);

        Review review = reviewService.createReview(req, user);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable Long productId) throws UserException, ProductException {
        List<Review> reviews = reviewService.getAllReview(productId);

        return new ResponseEntity<>( reviews, HttpStatus.ACCEPTED);
    }




}
