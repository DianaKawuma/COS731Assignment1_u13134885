package com.cos731.bellisimo.service.request;

import com.cos731.bellisimo.Request;

public class AddFoodItemRequest extends Request {

    private static final long serialVersionUID = 2665890930229308631L;
    Long foodId;

    public AddFoodItemRequest(Long foodId){
        this.foodId = foodId;
    }

    public Long getFoodId(){
        return  this.foodId;
    }
}
