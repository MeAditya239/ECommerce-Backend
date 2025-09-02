package com.aditya.ecommerce.repository;

import com.aditya.ecommerce.model.Cart;
import com.aditya.ecommerce.model.CartItem;
import com.aditya.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    @Query("SELECT c FROM CartItem c WHERE c.cart=:cart And c.product=:product And c.size=:size And c.userId=:userId")
    public CartItem isCartItemExist(@Param("cart") Cart cart, @Param("product") Product product, @Param("size") String size, @Param("userId") Long userId);
}