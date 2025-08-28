package com.aditya.ecommerce.model;


import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
public class Size {

    private String name;
    private int quantity;



}
