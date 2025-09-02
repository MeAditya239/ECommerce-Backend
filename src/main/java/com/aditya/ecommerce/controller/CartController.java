package com.aditya.ecommerce.controller;


import com.aditya.ecommerce.exception.ProductException;
import com.aditya.ecommerce.exception.UserException;
import com.aditya.ecommerce.model.Cart;
import com.aditya.ecommerce.model.User;
import com.aditya.ecommerce.request.AddItemRequest;
import com.aditya.ecommerce.response.ApiResponse;
import com.aditya.ecommerce.service.CartService;
import com.aditya.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
//@Tag( name= "Cart Management", description=" find user_cart, add item to cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    //@Operation(description = "find cart by user id")
    public ResponseEntity<Cart> findUserCart (@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt( jwt);
        Cart cart = cartService.findUserCart( user.getId());

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    //@Operation(description="add item to cart")
    public ResponseEntity<ApiResponse> addItemToCart (@RequestBody AddItemRequest req, @RequestHeader("authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(), req);

        ApiResponse res = new ApiResponse();
        res.setMessage("item added to cart");
        res.setStatus(true);

        return new ResponseEntity<>(res, HttpStatus.OK);

    }
}
