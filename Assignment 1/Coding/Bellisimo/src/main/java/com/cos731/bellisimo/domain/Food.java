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
@Table(name = "Food")
public class Food {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "itemName", nullable = false)
    private String itemName;

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public String getName() {
        return itemName;
    }

    @NotNull
    @Column(name = "price", nullable = false)
    private Long price;

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "photolink", nullable = false)
    private String photolink;

    public void setPhotolink(String photolink) {
        this.photolink = photolink;
    }

    public String getPhotolink() {
        return photolink;
    }

    @NotNull
    @Column(name = "category", nullable = false)
    private String category;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @NotNull
    @Column(name = "categoryType", nullable = false)
    private String categoryType;

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    @Override
    public String toString(){
        return "Food [itemName=" + itemName + ", price=" + price +
                ", photolink=" + photolink + ", category=" + category +
                ", categoryType=" + categoryType + "]";
    }
}
