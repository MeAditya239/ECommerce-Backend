package com.aditya.ecommerce.controller;


import com.aditya.ecommerce.exception.ProductException;
import com.aditya.ecommerce.exception.UserException;
import com.aditya.ecommerce.model.Rating;
import com.aditya.ecommerce.model.User;
import com.aditya.ecommerce.repository.RatingRepository;
import com.aditya.ecommerce.request.RatingRequest;
import com.aditya.ecommerce.service.RatingService;
import com.aditya.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {


    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> creatingrating (@RequestBody RatingRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt( jwt );
        Rating rating = ratingService.createRating( req , user);

        return new ResponseEntity<Rating>( rating, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating (@PathVariable Long productId,
                                                             @RequestHeader("Authorization") String jwt) throws UserException, ProductException {

        User user = userService.findUserProfileByJwt( jwt);

        List<Rating> ratings = ratingService.getProductsRating( productId);

        return new ResponseEntity<>(ratings, HttpStatus.CREATED);

    }
}
