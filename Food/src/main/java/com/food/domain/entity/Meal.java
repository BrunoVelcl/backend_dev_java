package com.food.domain.entity;

import jakarta.persistence.*;
import net.bytebuddy.utility.nullability.NeverNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String naziv;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<Ingredient> ingredients = new ArrayList<>();

    public Meal() {};

    public Meal(String naziv) {
        this.naziv = naziv;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(new Ingredient(ingredient, this));
    }

    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
