package com.cos731.bellisimo.service;

import com.cos731.bellisimo.domain.Clothing;
import com.cos731.bellisimo.domain.Food;
import com.cos731.bellisimo.repository.*;
import com.cos731.bellisimo.service.request.AddFoodItemRequest;
import com.cos731.bellisimo.service.request.DeleteFoodItemRequest;
import com.cos731.bellisimo.service.request.UpdateFoodItemRequest;
import com.cos731.bellisimo.service.response.AddFoodItemResponse;
import com.cos731.bellisimo.service.response.DeleteFoodItemResponse;
import com.cos731.bellisimo.service.response.UpdateFoodItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class ShopImpl implements Shop {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    ClothesRepository clothesRepository;

    public AddFoodItemResponse addFoodItem(AddFoodItemRequest request){
       // Optional<Food> food = foodRepository.findOneById(request.getFoodId());

        /*if(!food.isPresent()){
            //throw new Exception();
        } */

        foodRepository.save(new Food());
        return new AddFoodItemResponse();
    }

    public UpdateFoodItemResponse updateFoodItem(UpdateFoodItemRequest request){

        return new UpdateFoodItemResponse();
    }

    public DeleteFoodItemResponse deleteFoodItem(DeleteFoodItemRequest request){
        //Optional<Food> food = foodRepository.findOneById(request.getFoodId());

       /* if(!food.isPresent()){
            //throw new Exception();
        } */

       // foodRepository.delete(request.getFoodId());
        return new DeleteFoodItemResponse();
    }

}
