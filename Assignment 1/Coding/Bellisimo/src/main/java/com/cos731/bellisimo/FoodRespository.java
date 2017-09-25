package com.cos731.bellisimo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface FoodRespository extends CrudRepository<Food, Long> {
}
