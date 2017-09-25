package com.cos731.bellisimo;

import java.util.List;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@Controller
@RequestMapping("/api")
@EnableWebMvc
public class ApiController extends WebMvcConfigurerAdapter{
    //public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT","DELETE")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request_Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials").allowCredentials(true).maxAge(3600);
    }
    //UserService userService; //Service which will do all data retrieval/manipulation work
    @Autowired
    private FoodRespository foodRepository;

    @Autowired
    private ClothingRepository clothingRepository;


    //===============================================================================
                                //Food Section
    //===============================================================================

    // -------------------Retrieve All Food catalogues-------------------------------
    @CrossOrigin
    @RequestMapping(value = "/food/", method = RequestMethod.GET)
    public ResponseEntity<List<Food>> listAllFood() {
        //List<Food> users = userService.findAllUsers();
        List<Food> food = (List<Food>) foodRepository.findAll();
        if (food.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Food>>(food, HttpStatus.OK);
    }

    // -------------------Retrieve Single Food catalogue-----------------------------

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFood(@PathVariable("id") long id) {
        //logger.info("Fetching User with id {}", id);
        Food food = foodRepository.findOne(id);
       if (food == null) {
           return null;
       }
        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }

    // -------------------Create a Food catalogue----------------------------------

    @RequestMapping(value = "/food/", method = RequestMethod.POST)
    public ResponseEntity<?> createFood(@RequestBody Food food, UriComponentsBuilder ucBuilder) {
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

    // ------------------- Update a Food catalogue -----------------------------------

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
        currentFood.setCategoryType(food.getCategoryType());

        foodRepository.save(currentFood);
        return new ResponseEntity<Food>(currentFood, HttpStatus.OK);
    }

    // ------------------- Delete a Food catalogue-----------------------------------------
   @RequestMapping(value = "/food/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFood(@PathVariable("id") long id) {
        //logger.info("Fetching & Deleting User with id {}", id);
        Food user = foodRepository.findOne(id);
        if (user == null) {
            return null;
        }
       foodRepository.delete(id);
        return new ResponseEntity<Food>(HttpStatus.NO_CONTENT);
    }

    //===============================================================================
                                //Clothing Section
    //===============================================================================

    // -------------------Retrieve All Clothing catalogues---------------------------
    @RequestMapping(value = "/clothing/", method = RequestMethod.GET)
    public ResponseEntity<List<Clothing>> listAllClothes() {
        //List<Clothing> users = userService.findAllUsers();
        List<Clothing> clothing = (List<Clothing>) clothingRepository.findAll();
        if (clothing.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Clothing>>(clothing, HttpStatus.OK);
    }

    // -------------------Retrieve Single Clothing catalogue---------------------------

    @RequestMapping(value = "/clothing/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClothes(@PathVariable("id") long id) {
        //logger.info("Fetching Clothing with id {}", id);
        Clothing clothing = clothingRepository.findOne(id);
        if (clothing == null) {
            return null;
        }
        return new ResponseEntity<Clothing>(clothing, HttpStatus.OK);
    }

    // -------------------Create a Clothing catalogue----------------------------------

    @RequestMapping(value = "/clothing/", method = RequestMethod.POST)
    public ResponseEntity<?> createClothing(@RequestBody Clothing clothing, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating clothing : {}", clothing);

        /*if (foodService.isfoodExist(food)) {
            logger.error("Unable to create. A food with name {} already exist", food.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A food with name " +
                    food.getName() + " already exist."),HttpStatus.CONFLICT);
        } */
        clothingRepository.save(clothing);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/clothing/{id}").buildAndExpand(clothing.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    // ------------------- Update a Clothing catalogue ----------------------------------

    @RequestMapping(value = "/clothing/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClothing(@PathVariable("id") long id, @RequestBody Clothing clothing) {
        //logger.info("Updating clothing with id {}", id);

        Clothing currentClothing = clothingRepository.findOne(id);

        if (currentClothing == null) {
            return null;
        }

        currentClothing.setName(clothing.getName());
        currentClothing.setPrice(clothing.getPrice());
        currentClothing.setPhotolink(clothing.getPhotolink());
        currentClothing.setCategory(clothing.getCategory());
        currentClothing.setCategoryType(clothing.getCategoryType());

        clothingRepository.save(currentClothing);
        return new ResponseEntity<Clothing>(currentClothing, HttpStatus.OK);
    }

    // ------------------- Delete a Clothing catalogue-------------------------------
    @RequestMapping(value = "/clothing/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClothing(@PathVariable("id") long id) {
        //logger.info("Fetching & Deleting User with id {}", id);
        Clothing user = clothingRepository.findOne(id);
        if (user == null) {
            return null;
        }
        clothingRepository.delete(id);
        return new ResponseEntity<Clothing>(HttpStatus.NO_CONTENT);
    }

}
