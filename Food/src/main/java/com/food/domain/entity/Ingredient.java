package com.food.domain.entity;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String naziv;

    @JoinColumn(name = "meal_id")
    @ManyToOne
    Meal meal;

    public Ingredient(){}
    public Ingredient(String naziv, Meal meal) {
        this.naziv = naziv;
        this.meal = meal;
    }

    public Meal getMeal() {
        return meal;
    }

    public String getNaziv() {
        return naziv;
    }

    public Long getId() {
        return id;
    }
}
