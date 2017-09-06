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

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Diana
 */

@RestController
//@RequestMapping("/api")
public class FoodResource {

    @Autowired
    Shop shop;

    @Autowired
    FoodRepository foodRepository;

    /**
     * @param //pageable
     * @return
     */
   @RequestMapping("/food")//, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greet(){
       return "helloe from the other side";
   }
   /*@Transactional(readOnly = true)
   public ResponseEntity<List<FoodDTO>> getAllFood(Pageable pageable) throws URISyntaxException {

       Page<Food> page = foodRepository.findAll(pageable);
       List<FoodDTO> managedFoodDTOs = page.getContent().stream().map(FoodDTO::new).collect(Collectors.toList());
       return new ResponseEntity<>(managedFoodDTOs, HttpStatus.OK);
   } */

  /*  public String greet(){
        return "index";
    } */
    /*@Transactional(readOnly = true)
    public ResponseEntity<List<FoodDTO>> getFoodList(Pageable pageable){

        Page<Food> page = foodRepository.findAll( pageable);
        List<FoodDTO> foodlist = page.getContent().stream().map(FoodDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(foodlist, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<?> deleteFoodItem(@RequestBody DeleteFoodItemRequest request){
        shop.deleteFoodItem(request);

        return new ResponseEntity<>(HttpStatus.OK);

    } */
}
