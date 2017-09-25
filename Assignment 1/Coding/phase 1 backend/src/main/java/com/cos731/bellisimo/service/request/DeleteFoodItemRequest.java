package com.cos731.bellisimo.service.request;

import com.cos731.bellisimo.Request;

public class DeleteFoodItemRequest extends Request {

    private static final long serialVersionUID = 4694148033647138671L;
    Long foodId;

    public DeleteFoodItemRequest(Long foodId){
        this.foodId = foodId;
    }

    public Long getFoodId(){
        return  this.foodId;
    }
}
