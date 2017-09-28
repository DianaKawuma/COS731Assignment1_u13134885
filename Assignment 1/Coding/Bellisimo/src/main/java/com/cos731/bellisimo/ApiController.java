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
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT","DELETE")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request_Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials").allowCredentials(true).maxAge(3600);
    }

    @Autowired
    private FoodRespository foodRepository;

    @Autowired
    private ClothingRepository clothingRepository;

    @Autowired
    private UserRepository userRepository;


    //===============================================================================
                                //Food Section
    //===============================================================================

    // -------------------Retrieve All Food catalogues-------------------------------
    @CrossOrigin
    @RequestMapping(value = "/food/", method = RequestMethod.GET)
    public ResponseEntity<List<Food>> listAllFood() {
        List<Food> food = (List<Food>) foodRepository.findAll();
        if (food.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Food>>(food, HttpStatus.OK);
    }

    // -------------------Retrieve Single Food catalogue-----------------------------

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getFood(@PathVariable("id") long id) {
        Food food = foodRepository.findOne(id);
       if (food == null) {
           return null;
       }
        return new ResponseEntity<Food>(food, HttpStatus.OK);
    }

    // -------------------Create a Food catalogue----------------------------------

    @RequestMapping(value = "/food/", method = RequestMethod.POST)
    public ResponseEntity<?> createFood(@RequestBody Food food, UriComponentsBuilder ucBuilder) {
        foodRepository.save(food);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/food/{id}").buildAndExpand(food.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Food catalogue -----------------------------------

    @RequestMapping(value = "/food/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFood(@PathVariable("id") long id, @RequestBody Food food) {

        Food currentFood = foodRepository.findOne(id);

        if (currentFood == null) return null;

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
        Food user = foodRepository.findOne(id);
        if (user == null) return null;
       foodRepository.delete(id);
        return new ResponseEntity<Food>(HttpStatus.NO_CONTENT);
    }

    //===============================================================================
                                //Clothing Section
    //===============================================================================

    // -------------------Retrieve All Clothing catalogues---------------------------
    @RequestMapping(value = "/clothing/", method = RequestMethod.GET)
    public ResponseEntity<List<Clothing>> listAllClothes() {
        List<Clothing> clothing = (List<Clothing>) clothingRepository.findAll();
        if (clothing.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Clothing>>(clothing, HttpStatus.OK);
    }

    // -------------------Retrieve Single Clothing catalogue---------------------------

    @RequestMapping(value = "/clothing/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClothes(@PathVariable("id") long id) {
        Clothing clothing = clothingRepository.findOne(id);
        if (clothing == null) {
            return null;
        }
        return new ResponseEntity<Clothing>(clothing, HttpStatus.OK);
    }

    // -------------------Create a Clothing catalogue----------------------------------

    @RequestMapping(value = "/clothing/", method = RequestMethod.POST)
    public ResponseEntity<?> createClothing(@RequestBody Clothing clothing, UriComponentsBuilder ucBuilder) {
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

        if (currentClothing == null) return null;

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
        Clothing user = clothingRepository.findOne(id);
        if (user == null) return null;
        clothingRepository.delete(id);
        return new ResponseEntity<Clothing>(HttpStatus.NO_CONTENT);
    }

    //===============================================================================
                                    //User Section
    //===============================================================================

    // -------------------Retrieve Single User------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        User user = userRepository.findOne(id);
        if (user == null) return null;
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        userRepository.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {

        User currentUser = userRepository.findOne(id);

        if (currentUser == null) return null;

        currentUser.setName(user.getName());
        currentUser.setSurname(user.getSurname());
        currentUser.setUserName(user.getUserName());
        currentUser.setPassword(user.getPassword());
        currentUser.setProfilePicture(user.getProfilePicture());

        userRepository.save(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

}
