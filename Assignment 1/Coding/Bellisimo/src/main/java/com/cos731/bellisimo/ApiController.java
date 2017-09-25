package com.cos731.bellisimo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api")
public class ApiController {
    //public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    //UserService userService; //Service which will do all data retrieval/manipulation work
    @Autowired
    private FoodRespository foodRepository;

    // -------------------Retrieve All Food catalogues---------------------------------------------

    @RequestMapping(value = "/food/", method = RequestMethod.GET)
    public ResponseEntity<List<Food>> listAllUsers() {
        //List<Food> users = userService.findAllUsers();
        List<Food> food = (List<Food>) foodRepository.findAll();
        if (food.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Food>>(food, HttpStatus.OK);
    }

    // -------------------Retrieve Single Food catalogue------------------------------------------

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        //logger.info("Fetching User with id {}", id);
        Food food = foodRepository.findOne(id);
       if (food == null) {
           return null;
       }
        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }

    // -------------------Create a Food catalogue-------------------------------------------

    @RequestMapping(value = "/food/", method = RequestMethod.POST)
    public ResponseEntity<?> createfood(@RequestBody Food food, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating food : {}", food);

        /*if (foodService.isfoodExist(food)) {
            logger.error("Unable to create. A food with name {} already exist", food.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A food with name " +
                    food.getName() + " already exist."),HttpStatus.CONFLICT);
        } */
        foodRepository.save(food);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/food/{id}").buildAndExpand(food.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Food catalogue ------------------------------------------------

    @RequestMapping(value = "/food/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFood(@PathVariable("id") long id, @RequestBody Food food) {
        //logger.info("Updating User with id {}", id);

        Food currentFood = foodRepository.findOne(id);

        if (currentFood == null) {
            return null;
        }

        currentFood.setName(food.getName());
        currentFood.setPrice(food.getPrice());
        currentFood.setPhotolink(food.getPhotolink());
        currentFood.setCategory(food.getCategory());
        currentFood.setCategoryFilter(food.getCategoryFilter());
        currentFood.setCategoryType(food.getCategoryType());

        foodRepository.save(currentFood);
        return new ResponseEntity<Food>(currentFood, HttpStatus.OK);
    }

    // ------------------- Delete a Food catalogue-----------------------------------------
   @RequestMapping(value = "/food/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        //logger.info("Fetching & Deleting User with id {}", id);
        Food user = foodRepository.findOne(id);
        if (user == null) {
            return null;
        }
       foodRepository.delete(id);
        return new ResponseEntity<Food>(HttpStatus.NO_CONTENT);
    }

}
