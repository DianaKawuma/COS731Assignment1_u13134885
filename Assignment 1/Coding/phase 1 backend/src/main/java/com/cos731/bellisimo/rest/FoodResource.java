/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cos731.bellisimo.rest;

import com.cos731.bellisimo.domain.Food;
import com.cos731.bellisimo.repository.FoodRepository;
import com.cos731.bellisimo.rest.dto.FoodDTO;
import com.cos731.bellisimo.service.Shop;
import com.cos731.bellisimo.service.request.DeleteFoodItemRequest;
import com.cos731.bellisimo.service.request.UpdateFoodItemRequest;
import com.cos731.bellisimo.service.request.AddFoodItemRequest;
import com.cos731.bellisimo.service.response.UpdateFoodItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Diana
 */

@RestController
@RequestMapping("/api")
public class FoodResource {

    @Autowired
    Shop shop;

    @Autowired
    FoodRepository foodRepository;

    /**
     * @param pageable
     * @return
     */
   @RequestMapping(value="/foodList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    /*public String greet(){
       return "helloe from the other side";
   } */
   @Transactional(readOnly = true)
   public ResponseEntity<List<FoodDTO>> getAllFood(Pageable pageable) throws URISyntaxException {

       Page<Food> page = foodRepository.findAll(pageable);
       List<FoodDTO> managedFoodDTOs = page.getContent().stream().map(FoodDTO::new).collect(Collectors.toList());
       return new ResponseEntity<>(managedFoodDTOs, HttpStatus.OK);
   }

    @RequestMapping(value = "/deleteFood", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> deleteFoodItem(@RequestBody DeleteFoodItemRequest request){
        shop.deleteFoodItem(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateFood", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<FoodDTO> updateFoodItem(@RequestBody UpdateFoodItemRequest request){
        Food  food = shop.updateFoodItem(request);
        return new ResponseEntity<>(new FoodDTO(food), HttpStatus.OK);
    }

   /* @RequestMapping(value = "/addFood", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<FoodDTO> addFoodItem(@RequestBody AddFoodItemRequest request) throws URISyntaxException {
        //Food  food = shop.addFoodItem(request);
        //return ResponseEntity.created(new URI(food.getName())).body(new FoodDTO(food));
    } */

}
