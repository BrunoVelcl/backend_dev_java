package com.food.domain.repository;

import com.food.domain.entity.Meal;

import java.util.List;

public interface MealRepository {
    boolean saveMeal(Meal meal);
    List<Meal> findAll();
}
