package com.aditya.ecommerce.service;

import com.aditya.ecommerce.exception.CartItemException;
import com.aditya.ecommerce.exception.UserException;
import com.aditya.ecommerce.model.Cart;
import com.aditya.ecommerce.model.CartItem;
import com.aditya.ecommerce.model.Product;

public interface CartItemService
{
    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId,Long id,CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}