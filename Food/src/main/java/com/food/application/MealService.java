package com.food.application;

import com.food.domain.entity.Ingredient;
import com.food.domain.entity.Meal;
import com.food.infrastructure.MealRepositoryImp;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MealService {
    public void run(){
        StringBuilder sb = new StringBuilder();
        final String NEW_LINE = System.lineSeparator();
        try(SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            MealRepositoryImp mealRepo = new MealRepositoryImp(sf);

//            Meal margarita = new Meal("Margarita");
//            margarita.addIngredient("Rajčica");
//            margarita.addIngredient("Sir");
//
//            if(mealRepo.saveMeal(margarita)){
//                System.out.println("GREAT SUCCSESS!");
//            }else{
//                System.out.println("FAILED!");
//            }
//
//            Meal slavonska = new Meal("Slavonska");
//            slavonska.addIngredient("Rajčica");
//            slavonska.addIngredient("Sir");
//            slavonska.addIngredient("Šunka");
//            slavonska.addIngredient("Šampinjoni");
//            slavonska.addIngredient("Feferoni");
//
//            if(mealRepo.saveMeal(slavonska)){
//                System.out.println("GREAT SUCCSESS!");
//            }else{
//                System.out.println("FAILED!");
//            }

            var meals = mealRepo.findAll();
            for(Meal m : meals){
                sb
                        .append("***********************")
                        .append(NEW_LINE)
                        .append(m.getNaziv())
                        .append(": ");
                for(Ingredient ing : m.getIngredients()){
                    sb
                            .append(ing.getNaziv())
                            .append(",");
                }
                sb.setLength(sb.length()-1);
                sb.append(NEW_LINE);
            }

        }
        System.out.println(sb);
    }
}
