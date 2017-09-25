package com.cos731.bellisimo;

import javax.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Clothing")
public class Clothing {
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

    @NotNull
    @Column(name="categoryFilter", nullable = false)
    private String categoryFilter;

    public String getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(String categoryFilter) {
        this.categoryFilter = categoryFilter;
    }
    /* @Override
    public String toString(){
        return "Food [itemName=" + itemName + ", price=" + price +
                ", photolink=" + photolink + ", category=" + category +
                ", categoryType=" + categoryType + "]";
    } */

}
