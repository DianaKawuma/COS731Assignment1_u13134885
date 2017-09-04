package com.cos731.bellisimo.rest.dto;

import com.cos731.bellisimo.domain.Food;

import javax.validation.constraints.NotNull;

public class FoodDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long price;

    @NotNull
    private String photolink;

    @NotNull
    private String category;

    @NotNull
    private String categoryType;

    public FoodDTO(Food food) {
        this(food.getName(), food.getPrice(), food.getPhotolink(),
                food.getCategory(), food.getCategoryType()
        );
    }

    public FoodDTO(String name, Long price, String photolink, String category, String categoryType){
        this.name = name;
        this.price = price;
        this.photolink = photolink;
        this.category = category;
        this.categoryType = categoryType;
    }
}
