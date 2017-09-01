/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cos731.bellisimo.domain;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

/**
 *
 * @author Diana
 */

@Entity
@Table(name = "Food")
public class Food {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;


    
}
