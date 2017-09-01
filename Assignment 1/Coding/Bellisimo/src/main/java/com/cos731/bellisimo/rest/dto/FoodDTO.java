package com.cos731.bellisimo.rest.dto;

import com.cos731.bellisimo.domain.Food;

public class FoodDTO {

    private Long id;

    public FoodDTO(){

    }

    public FoodDTO(Food food) {
        this();
    }

    public FoodDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
