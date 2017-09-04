/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cos731.bellisimo.domain;


import javax.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author Diana
 */

@Data
@Entity
@Table(name = "FoodData")
public class Food {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "itemName", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    @NotNull
    @Column(name = "price", nullable = false)
    private Long price;

    public Long getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "photolink", nullable = false)
    private String photolink;

    public String getPhotolink() {
        return photolink;
    }

    @NotNull
    @Column(name = "category", nullable = false)
    private String category;

    public String getCategory() {
        return category;
    }

    @NotNull
    @Column(name = "categoryType", nullable = false)
    private String categoryType;

    public String getCategoryType() {
        return categoryType;
    }
}
