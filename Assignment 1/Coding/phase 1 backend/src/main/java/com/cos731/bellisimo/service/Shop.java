package com.cos731.bellisimo.service;

import com.cos731.bellisimo.service.request.AddFoodItemRequest;
import com.cos731.bellisimo.service.request.DeleteFoodItemRequest;
import com.cos731.bellisimo.service.request.UpdateFoodItemRequest;
import com.cos731.bellisimo.service.response.AddFoodItemResponse;
import com.cos731.bellisimo.service.response.DeleteFoodItemResponse;
import com.cos731.bellisimo.service.response.UpdateFoodItemResponse;

public interface Shop {

    AddFoodItemResponse addFoodItem(AddFoodItemRequest request);
    UpdateFoodItemResponse updateFoodItem(UpdateFoodItemRequest request);
    DeleteFoodItemResponse deleteFoodItem(DeleteFoodItemRequest request);



}
