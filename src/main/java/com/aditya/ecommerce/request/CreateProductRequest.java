package com.aditya.ecommerce.request;

import com.aditya.ecommerce.model.Size;

import lombok.Data;



import java.util.HashSet;
import java.util.Set;

@Data
public class CreateProductRequest {

    private String title;
    private String description;
    private int price;
    private int discountedPrice;
    private int discountPresent;
    private int quantity;
    private String brand;
    private String color;

    private Set<Size> size = new HashSet<>();

    private String imageUrl;

    private String topLevelCategory;
    private String secondLevelCategory;
    private String thirdLevelCategory;

}
