package com.aditya.ecommerce.service;

import com.aditya.ecommerce.exception.ProductException;
import com.aditya.ecommerce.model.Cart;
import com.aditya.ecommerce.model.User;
import com.aditya.ecommerce.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);
}