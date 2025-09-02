package com.aditya.ecommerce.repository;


import java.util.List;

import com.aditya.ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{


    List<OrderItem> findByProductId(Long productId);
    void deleteByProductId(Long productId);
}
