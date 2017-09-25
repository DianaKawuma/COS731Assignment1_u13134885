package com.cos731.bellisimo.repository;


import java.util.List;

import com.cos731.bellisimo.domain.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
//Serves as the data access layer in Spring Data Rest
public interface FoodRepository extends CrudRepository<Food, Integer> {

    //Optional<Food> findOneById(Long id);

    Page<Food> findAll(Pageable pageable);
    //List<Food> findByFoodArchived(@Param("archivedfalse") int foodArchivedFalse);
    //List<Food> findByFoodStatus(@Param("status") String foodStatus);
}
