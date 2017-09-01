package com.cos731.bellisimo.repository;

import com.cos731.bellisimo.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findOneById(Long id);
}
