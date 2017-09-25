package com.cos731.bellisimo.repository;

import com.cos731.bellisimo.domain.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<Clothing, Long> {
}
