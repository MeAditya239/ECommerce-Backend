package com.aditya.ecommerce.response;


import com.aditya.ecommerce.model.Product;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class ProductResponseDTO {
    private List<Product> products;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;

    public ProductResponseDTO(Page<Product> page) {
        this.products = page.getContent();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.lastPage = page.isLast();
    }
}