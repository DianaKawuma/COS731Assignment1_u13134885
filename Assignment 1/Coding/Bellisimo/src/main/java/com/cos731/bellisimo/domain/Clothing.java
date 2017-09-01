/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cos731.bellisimo.domain;

import lombok.Data;
import javax.validation.constraints.NotNull;

import javax.persistence.*;

/**
 *
 * @author Diana
 */

@Data
@Entity
@Table(name = "Clothing")
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "itemName", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Long price;

    @NotNull
    @Column(name = "photolink", nullable = false)
    private String photolink;

    @NotNull
    @Column(name = "category", nullable = false)
    private String category;

    @NotNull
    @Column(name = "categoryType", nullable = false)
    private String categoryType;

    @NotNull
    @Column(name = "gender", nullable = false)
    private String gender;
}
