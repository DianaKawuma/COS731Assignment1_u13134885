/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cos731.bellisimo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diana
 */

@RestController
@RequestMapping("/food")
public class FoodResource {
    
    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String Hello(){
        return "Hello";
    }
}
