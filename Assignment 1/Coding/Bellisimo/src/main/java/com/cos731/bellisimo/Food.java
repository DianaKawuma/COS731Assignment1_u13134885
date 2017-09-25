package com.cos731.bellisimo;

import javax.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Food")
public class Food {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@NotNull
    @Column(name = "itemName")
    private String itemName;

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public String getName() {
        return itemName;
    }

    //@NotNull
    @Column(name = "price")
    private Long price;

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    //@NotNull
    @Column(name = "photolink")
    private String photolink;

    public void setPhotolink(String photolink) {
        this.photolink = photolink;
    }

    public String getPhotolink() {
        return photolink;
    }

   // @NotNull
    @Column(name = "category")
    private String category;

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

   // @NotNull
    @Column(name = "categoryType")
    private String categoryType;

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryType() {
        return categoryType;
    }

    /* @Override
    public String toString(){
        return "Food [itemName=" + itemName + ", price=" + price +
                ", photolink=" + photolink + ", category=" + category +
                ", categoryType=" + categoryType + "]";
    } */

}
